package cn.bushadie.designPatterns.createPatterns.FactoryPattern;

import cn.bushadie.designPatterns.rubbish.AmericanFoodA;
import cn.bushadie.designPatterns.rubbish.AmericanFoodB;
import cn.bushadie.designPatterns.rubbish.Food;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class AmericanFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new AmericanFoodA();
        } else if (name.equals("B")) {
            return new AmericanFoodB();
        } else {
            return null;
        }
    }
}
