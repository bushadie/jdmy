package cn.bushadie.designPatterns.StructurePatterns.DecoratorPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class BlackTea extends Beverage {
    public String getDescription() {
        return "红茶";
    }
    public double cost() {
        return 10;
    }
}
