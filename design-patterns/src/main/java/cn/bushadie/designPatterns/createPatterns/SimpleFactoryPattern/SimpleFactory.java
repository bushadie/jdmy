package cn.bushadie.designPatterns.createPatterns.SimpleFactoryPattern;


import cn.bushadie.designPatterns.rubbish.Food;
import cn.bushadie.designPatterns.rubbish.HuangMenChicken;
import cn.bushadie.designPatterns.rubbish.LanZhouNoodle;

/**
 * @author jdmy
 * on 2018/11/19.
 * 创建模式  简单工程模式
 * 简单地说，简单工厂模式通常就是这样，一个工厂类 XxxFactory，
 * 里面有一个静态方法，根据我们不同的参数，返回不同的派生自同一个父类（或实现同一接口）的实例对象。
 **/
public class SimpleFactory {
    public static Food makeFood(String name) {
        if (name.equals("noodle")) {
            Food noodle = new LanZhouNoodle();
            noodle.addSpicy("more");
            return noodle;
        } else if (name.equals("chicken")) {
            Food chicken = new HuangMenChicken();
            chicken.addCondiment("potato");
            return chicken;
        } else {
            return null;
        }
    }

}

