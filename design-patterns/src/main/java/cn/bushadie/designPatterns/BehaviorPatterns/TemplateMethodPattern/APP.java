package cn.bushadie.designPatterns.BehaviorPatterns.TemplateMethodPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class APP {
    public static void main(String[] args) {
        AbstractTemplate t = new ConcreteTemplate();
        // 调用模板方法
        t.templateMethod();
    }
}
