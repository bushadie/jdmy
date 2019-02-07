package cn.bushadie.test.test.proxy;

/**
 * @author jdmy
 * on 2018/12/10.
 **/
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
