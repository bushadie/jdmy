package cn.bushadie.jooq.configuration;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import org.jooq.Record;
import org.jooq.RecordContext;
import org.jooq.impl.DefaultRecordListener;

/**
 * @author jdmy
 * on 2019/3/31.
 * 在 DslContextPostProcessor 中使用了,插入前的操作
 **/
public class DslContextRecordListener extends DefaultRecordListener {

    @Override
    public void insertStart(RecordContext ctx) {
        System.out.println("DslContextRecordListener");
        Record record=ctx.record();
//        // 统一的对id进行了复制, 相当于数据库随机生成了uuid
        if(ReflectUtil.getMethod(record.getClass(),"setId",String.class)!=null) {
            ReflectUtil.invoke(record, "setId",IdUtil.fastSimpleUUID());
//            //            使用外部的反射会出现警告,但是自带的反射不知道要怎么设置
//            //            todo  自带的反射工具,需要熟悉
//            //            try {
//            //                Reflect on=Reflect.on(record.getClass());//
//            //                on.set("id",IdUtil.fastSimpleUUID());
//            //            }catch(ReflectException e) {
//            //                e.printStackTrace();
//            //            }
        }
//        if( record instanceof UserRecord){
//            ((UserRecord)record).setAge(120);
//        }
//        super.insertStart(ctx);
    }
}
