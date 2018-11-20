package cn.bushadie.designPatterns.StructurePatterns.DecoratorPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class Mango extends Condiment {
    private Beverage beverage;
    public Mango(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", 加芒果";
    }
    public double cost() {
        return beverage.cost() + 3; // 加芒果需要 3 元
    }
}