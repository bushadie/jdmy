package cn.bushadie.designPatterns.StructurePatterns.DecoratorPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class GreenTea extends Beverage {
    public String getDescription() {
        return "绿茶";
    }
    public double cost() {
        return 11;
    }
}