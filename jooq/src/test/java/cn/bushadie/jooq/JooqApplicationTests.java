package cn.bushadie.jooq;

import cn.bushadie.jooq.generator.Tables;
import cn.bushadie.jooq.generator.tables.Userinfo;
import cn.bushadie.jooq.generator.tables.daos.UserDao;
import cn.bushadie.jooq.generator.tables.pojos.User;
import cn.bushadie.jooq.generator.tables.pojos.Userkv;
import cn.bushadie.jooq.generator.tables.records.UserRecord;
import cn.bushadie.jooq.generator.tables.records.UserkvRecord;
import cn.hutool.core.util.ArrayUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jooq.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.ConstructorProperties;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static org.jooq.impl.DSL.row;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JooqApplicationTests {

    @Autowired
    //    @Qualifier("dslContextLock")
    @Qualifier("dslContext")
    private DSLContext dslContext;

    @Autowired
    private UserDao userDao;

    @Test
    public void dslContext() {
        System.out.println(dslContext);
    }

    @Test
    public void t1() {
        System.out.println(dslContext);
    }

    @Test
    public void select() {
        SelectJoinStep<Record> from=dslContext.select().from(Tables.USER);
        List<User> users=from.fetch().map(record->record.into(User.class));
        System.out.println(users);
    }

    /**
     * 插入单条数据
     */
    @Test
    public void insertSingle() {
        dslContext.insertInto(Tables.USER,
                Tables.USER.NAME)
                .values("3456").execute();
    }

    /**
     * 插入多条数据
     */
    @Test
    public void insertMultiple() {
        dslContext.insertInto(Tables.USER,
                Tables.USER.NAME)
                .values("aaa")
                .values("bbb")
                .execute();
    }

    @Test
    public void insertRecord() {
        UserRecord user=new UserRecord();
        user.setAge(111);
        user.setName("byz");
        Batch batch=dslContext.batchStore(user);
        System.out.println("---------------------------");
        System.out.println(user.toString());
        System.out.println(user.intoList());
        System.out.println("---------------------------");
        System.out.println(user.getValue(Tables.USER.ID));
    }

    /**
     * 用set的方式插入
     */
    @Test
    public void insertSet() {
        dslContext.insertInto(Tables.USER)
                .set(Tables.USER.NAME,"insertSet1")
                .newRecord()
                .set(Tables.USER.NAME,"insertSet2")
                .execute();
    }

    @Test
    public void updateSet() {
        dslContext.update(Tables.USER)
                .set(Tables.USER.NAME,"name")
                .where(Tables.USER.NAME.like("%34%"))
                .execute();
    }

    /**
     * 使用row的方式修改
     */
    @Test
    public void updateRow() {
        dslContext.update(Tables.USER)
                .set(row(Tables.USER.NAME,Tables.USER.AGE),
                        row("row",18))
                .where(Tables.USER.ID.eq("1"))
                .execute();

    }

    /**
     * mysql 不行
     */
    @Test
    public void updateFrom() {
        dslContext.update(Tables.USER)
                .set(Tables.USER.AGE,Tables.USER.AGE)
                .from(Tables.USER)
                .where(Tables.USER.ID.eq(Tables.USER.ID))
                .execute();
    }

    @Test
    public void delete() {
        int count=dslContext.delete(Tables.USER)
                .where(Tables.USER.ID.eq("8"))
                .execute();
        System.out.println(count);
    }


    @Test
    public void selectJoin() {
        Result<Record> result=dslContext.select()
                .from(Tables.USER)
                .rightJoin(Tables.USERINFO)
                .on(Tables.USER.ID.eq(Tables.USERINFO.USERID))
                .fetch();
        List<User> list=result.map(record->record.into(User.class));
        System.out.println(list);
    }

    /**
     * 读取fetch到的数据
     */
    @Test
    public void readSelect() {
        Result<UserRecord> result=dslContext.selectFrom(Tables.USER).fetch();
        List<UserRecord> list=result.map(record->record.into(Tables.USER));
        for(UserRecord item: result) {
            // 这是获取id 的数据,其他的也一样
            System.out.print(item.getValue("id"));
            // 转化成json格式
            // System.out.print(item.formatJSON());
            //  这样修改后能自动存储
            //  item.setAge(11);item.store();
        }
        System.out.println();
        //  尝试用这种方式得到的 record 是否可以直接删除  结论: 可以删除
        System.out.println(list.get(list.size()-1));
        list.get(list.size()-1).delete();
    }

    /**
     * 使用map和类的构造方法获得相应数据
     */
    @Test
    public void lambdaNew() {
        @Data
        @Accessors(chain=true)
        class Temp {
            private String name;
            private Integer age;

            Temp() {
            }

            public Temp(String name,Integer age) {
                this.name=name;
                this.age=age;
            }
        }
        List<Temp> list1=dslContext.selectFrom(Tables.USER).fetch()
                .map(record->new Temp(
                        record.getValue(Tables.USER.NAME),
                        record.getValue(Tables.USER.AGE)
                ));
        List<Temp> list2=dslContext.selectFrom(Tables.USER).fetch()
                .map(record->{
                    Temp temp=new Temp();
                    temp.setAge(record.getAge()).setName(record.getName());
                    return temp;
                });
        System.out.println("list1 = "+list1);
        System.out.println("list2 = "+list2);
    }

    @Test
    public void readJoinSelect() {
        Result<Record2<String,String>> result=dslContext.select(Tables.USER.ID,Tables.USERINFO.ID)
                .from(Tables.USER)
                .rightJoin(Tables.USERINFO)
                .on(Tables.USER.ID.eq(Tables.USERINFO.USERID))
                .fetch();
        for(Record item: result) {
            System.out.println(item);
            System.out.println(item.getValue(Tables.USERINFO.ID));
            System.out.println(item.getValue(Tables.USER.ID));
        }
    }

    /**
     * 别名
     */
    @Test
    public void alias() {
        cn.bushadie.jooq.generator.tables.User u=Tables.USER.as("u");
        Userinfo i=Tables.USERINFO.as("i");
        Result<Record> fetch=dslContext.select()
                .from(u)
                .rightJoin(i)
                .on(u.ID.eq(i.USERID))
                .fetch();
        List<User> list=fetch.map(record->record.into(User.class));
        System.out.println(list);
    }


    /**
     * 一对多查询
     */
    @Test
    public void one2More() {
        Result<Record> result=dslContext.select(ArrayUtil.addAll(Tables.USER.fields(),Tables.USERKV.fields()))
                .from(Tables.USER)
                .rightJoin(Tables.USERKV)
                .on(Tables.USERKV.USERID.eq(Tables.USER.ID))
                .fetch();
        System.out.println(result);
        Map<UserRecord,Result<UserkvRecord>> map=result.intoGroups(Tables.USER,Tables.USERKV);
        System.out.println(map.size());
        for(UserRecord key: map.keySet()) {
            System.out.println(key);
            Result<UserkvRecord> value=map.get(key);
            for(UserkvRecord item: value) {
                System.out.println(item.into(Userkv.class));
            }
        }
    }

    /**
     * 一对一查询
     */
    @Test
    public void one2one() {
        @Data
        class Temp {
            private String id;
            private String address;
            private String name;
            private Integer age;

            public Temp(Temp temp) {
                id=temp.id;
                address=temp.address;
                name=temp.name;
                age=temp.age;
            }

            public Temp(Record record) {
                id=record.getValue(Tables.USER.ID);
                name=record.getValue(Tables.USER.NAME);
                age=record.getValue(Tables.USER.AGE,Integer.class);
                address=record.getValue(Tables.USERINFO.ADDRESS);
            }

            @ConstructorProperties({"id","address","name","age"})
            public Temp(String id,String address,String name,Integer age) {
                this.id=id;
                this.address=address;
                this.name=name;
                this.age=age;
            }

            public Temp() {

            }
        }
        Result<Record> fetch=dslContext.select()
                .from(Tables.USER)
                .rightJoin(Tables.USERINFO)
                .on(Tables.USER.ID.eq(Tables.USERINFO.USERID))
                .fetch();
        for(Record record: fetch) {
            System.out.println("--------------------------------------");
            //            暂时解决不了
            //            System.out.println(record.into(Temp.class));
            System.out.println(record.into(User.class));
            System.out.println(new Temp(record));
            System.out.println(record.into(Tables.USER));
            System.out.println(record.into(Tables.USERINFO));
            UserRecord userRecord=dslContext.newRecord(Tables.USER);
        }
    }

    /**
     * 对userDao的测试
     */
    @Test
    public void dao() {
        List<User> list=userDao.fetchByName("aaa","bbb");
        System.out.println(list);
    }

    /**
     * 生成id   有错,不知道 sequence怎么弄
     */
    @Test
    public void generate() {
        BigInteger b1=dslContext.nextval("user");
        System.out.println(b1);
    }

    /**
     * 分页方法
     */
    @Test
    public void seek() {
        Result<Record> result=dslContext.select().from(Tables.USER)
                .orderBy(Tables.USER.ID.asc())
                .seek("3")
                .limit(2)
                .fetch();
        System.out.println(result.format());
        for(Record item: result) {
            System.out.println(item.into(User.class));
        }
    }

    /**
     * 直接对 record 操作
     */
    @Test
    public void record() {
        UserRecord user=dslContext.newRecord(Tables.USER);
        user.setName("record");
        user.store();
        //  在这断点,同时在外面修改数据
        user.refresh();
        System.out.println(user);
        System.out.println(dslContext.selectFrom(Tables.USER).fetch());
        user.setName("record === record");
        user.store();
        System.out.println(dslContext.selectFrom(Tables.USER).fetch());
        user.delete();
        System.out.println(dslContext.selectFrom(Tables.USER).fetch());
    }

    /**
     * 乐观锁配置
     */
    @Test
    public void optimisticLocking() {

        System.out.println(dslContext);
        dslContext.settings().setExecuteWithOptimisticLockingExcludeUnversioned(true);
        System.out.println(dslContext);
        UserRecord user=dslContext.fetchOne(Tables.USER,Tables.USER.ID.eq("4"));
        user.setName("locking");
        user.store();
    }

    @Test
    public void saveListener() {
        UserRecord user=dslContext.newRecord(Tables.USER);
        user.setName("listner");
        user.store();
        // 注意!!  不refresh会出错
        user.refresh();
        user.delete();
    }

    /**
     * 直接使用transaction方法实现事务
     */
    @Test
    public void transaction() {
        try {
            dslContext.transaction(configuration->{
                UserRecord user=dslContext.newRecord(Tables.USER);
                user.setName("transaction");
                user.store();
                //            利用不 refresh的会失败的特点, 体验事务   数据库中不会添加数据,原来会
                user.delete();
            });
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

