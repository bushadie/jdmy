package cn.bushadie.jooq.configuration;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.jooq.ExecuteContext;
import org.jooq.Field;
import org.jooq.InsertQuery;
import org.jooq.impl.DefaultExecuteListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author jdmy
 * on 2019/4/19.
 **/
@Slf4j
public class DslContextExecuteListener extends DefaultExecuteListener {

    @Override
    public void bindStart(ExecuteContext ctx) {
        System.out.println(ctx);

    }

    /**
     * 渲染开始
     * @param ctx
     */
    @Override
    public void renderStart(ExecuteContext ctx) {
        addId(ctx);

    }

    public void addId(ExecuteContext ctx) {
        System.out.println("DslContextExecuteListener");
        //  这里直接使用 ctx.query() 来判断,不要用变量接收
        if(ctx.query() instanceof InsertQuery) {
            // 插入的 表 数据全在这里
            Object table=ReflectUtil.getFieldValue(ctx.query(),"table");
            // 得到需要的列
            Object fieldValue=ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"table"),"ID");
            Integer rows=(Integer)ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"insertMaps"),"rows");
            Integer nextRow=(Integer)ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"insertMaps"),"nextRow");
            for(int rowsId=1, nextRowId=0;rowsId<=rows&&nextRowId<=nextRow;rowsId++,nextRowId++) {
                ((InsertQuery)ctx.query()).addValue((Field)fieldValue,IdUtil.fastSimpleUUID());
                ReflectUtil.setFieldValue(ReflectUtil.getFieldValue(ctx.query(),"insertMaps"),"rows",rowsId);
                ReflectUtil.setFieldValue(ReflectUtil.getFieldValue(ctx.query(),"insertMaps"),"nextRow",nextRowId);
            }
            System.out.println("-----------------------------------");
        }
    }



    public void addId1(ExecuteContext ctx){
        //  这里直接使用 ctx.query() 来判断,不要用变量接收
        if( ctx.query() instanceof InsertQuery){
            // 插入的 表 数据全在这里
            Object table=ReflectUtil.getFieldValue(ctx.query(),"table");
            // 得到需要的列
            Object colName=ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"table"),"ID");
            Integer nums=(Integer)ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"insertMaps"),"rows");
            LinkedHashMap idLinkedHashMap=(LinkedHashMap)ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"insertMaps"),"values");
            ArrayList<String> idList=new ArrayList<>(nums);
            idLinkedHashMap.put((Field)colName,idList);
            for(int i=0;i<nums;i++) {
                // 在想要的列中添加具体数据
                idList.add(IdUtil.fastSimpleUUID());
                //                ((InsertQuery)ctx.query()).addValue((Field)colName,IdUtil.fastSimpleUUID());
            }
            System.out.println("------------InsertQuery--------------");
        }
    }

    @Override
    public void executeStart(ExecuteContext ctx) {
    }

    /**
     * 结束打印日志
     */
    @Override
    public void executeEnd(ExecuteContext ctx) {
        showQuery(ctx);
    }

    @Override
    public void exception(ExecuteContext ctx) {
        if( ctx.query() != null ){
            log.error("这条SQL  {}  出现异常",ctx.query().toString().replaceAll("\n"," "));
        }
    }

    public void showQuery(ExecuteContext ctx){
        if( ctx.query() != null ){
            log.info(ctx.query().toString().replaceAll("\n"," "));
        }
    }

}
