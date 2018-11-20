package cn.bushadie.designPatterns.createPatterns.FactoryPattern;

import cn.bushadie.designPatterns.rubbish.ChineseFoodA;
import cn.bushadie.designPatterns.rubbish.ChineseFoodB;
import cn.bushadie.designPatterns.rubbish.Food;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if(name.equals("A")) {
            return new ChineseFoodA();
        }else if(name.equals("B")) {
            return new ChineseFoodB();
        }else {
            return null;
        }
    }
}
