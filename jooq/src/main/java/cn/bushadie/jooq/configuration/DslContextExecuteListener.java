package cn.bushadie.jooq.configuration;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.jooq.ExecuteContext;
import org.jooq.Field;
import org.jooq.InsertQuery;
import org.jooq.impl.DefaultExecuteListener;

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
        //  这里直接使用 ctx.query() 来判断,不要用变量接收
        if( ctx.query() instanceof InsertQuery){
            // 插入的 表 数据全在这里
            Object table=ReflectUtil.getFieldValue(ctx.query(),"table");
            // 得到需要的列
            Object fieldValue=ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(ctx.query(),"table"),"ID");
            // 在想要的列中添加具体数据
            ((InsertQuery)ctx.query()).addValue((Field)fieldValue,IdUtil.fastSimpleUUID());
        }

    }

    @Override
    public void executeStart(ExecuteContext ctx) {
        System.out.println(ctx);
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
