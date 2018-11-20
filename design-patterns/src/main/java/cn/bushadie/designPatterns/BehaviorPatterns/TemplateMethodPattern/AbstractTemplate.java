package cn.bushadie.designPatterns.BehaviorPatterns.TemplateMethodPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 *
 * 模板方法中调用了 3 个方法，
 * 其中 apply() 是抽象方法，子类必须实现它，
 * 其实模板方法中有几个抽象方法完全是自由的，
 * 我们也可以将三个方法都设置为抽象方法，让子类来实现。
 * 也就是说，模板方法只负责定义第一步应该要做什么，第二步应该做什么，第三步应该做什么，
 * 至于怎么做，由子类来实现。
 **/
public abstract class AbstractTemplate {
    // 这就是模板方法
    public void templateMethod(){
        init();
        apply(); // 这个是重点
        end(); // 可以作为钩子方法
    }
    protected void init() {
        System.out.println("init 抽象层已经实现，子类也可以选择覆写");
    }
    // 留给子类实现
    protected abstract void apply();
    protected void end() {
    }
}

