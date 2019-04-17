package cn.bushadie.jooq.configuration;

import org.jooq.DSLContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author jdmy
 * on 2019/3/30.
 **/
@Component
public class DslContextPostProcessor implements BeanFactoryPostProcessor, BeanPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("进入BeanFactory后处理器...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException {
        // bean 前置处器
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException {
        // 得到这个bean,做相应处理
        if( "dslContext".equals(beanName) ){
            DSLContext dslContext=(DSLContext)bean;
            //  乐观锁配置
            dslContext.settings().setExecuteWithOptimisticLocking(true);
            // 监听器配置
            dslContext.configuration().set(new DlsContextListener());
        }
        return bean;
    }
}
