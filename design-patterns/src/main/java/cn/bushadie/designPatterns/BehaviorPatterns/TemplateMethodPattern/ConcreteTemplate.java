package cn.bushadie.designPatterns.BehaviorPatterns.TemplateMethodPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class ConcreteTemplate extends AbstractTemplate {
    public void apply() {
        System.out.println("子类实现抽象方法 apply");
    }
    public void end() {
        System.out.println("我们可以把 method3 当做钩子方法来使用，需要的时候覆写就可以了");
    }
}
