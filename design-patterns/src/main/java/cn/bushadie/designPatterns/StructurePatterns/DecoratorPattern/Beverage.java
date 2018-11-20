package cn.bushadie.designPatterns.StructurePatterns.DecoratorPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public abstract class Beverage {
    // 返回描述
    public abstract String getDescription();
    // 返回价格
    public abstract double cost();
}
