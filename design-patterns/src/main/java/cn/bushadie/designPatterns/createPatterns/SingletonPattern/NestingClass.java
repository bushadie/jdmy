package cn.bushadie.designPatterns.createPatterns.SingletonPattern;

/**
 * @author jdmy
 * on 2018/11/19.
 * 嵌套类
 *
 * 注意，很多人都会把这个嵌套类说成是静态内部类，
 * 严格地说，内部类和嵌套类是不一样的，它们能访问的外部类权限也是不一样的
 **/
public class NestingClass {
    private NestingClass() {}
    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    private static class Holder {
        private static NestingClass instance = new NestingClass();
    }
    public static NestingClass getInstance() {
        return Holder.instance;
    }
}
