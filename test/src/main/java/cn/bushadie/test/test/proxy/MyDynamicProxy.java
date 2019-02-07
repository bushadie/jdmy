package cn.bushadie.test.test.proxy;

import java.lang.reflect.Proxy;

/**
 * @author jdmy
 * on 2018/12/10.
 **/
public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello=new HelloImpl();
        MyInvocationHandler handler=new MyInvocationHandler(hello);
        Hello proxyHello = (Hello)Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),new Class[]{Hello.class},handler);
        proxyHello.sayHello();
    }
}
