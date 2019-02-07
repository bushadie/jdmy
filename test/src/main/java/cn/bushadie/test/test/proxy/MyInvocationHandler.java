package cn.bushadie.test.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jdmy
 * on 2018/12/10.
 **/
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
        System.out.println("Invoking sayHello");
        return method.invoke(target,args);
    }
}
