package cn.bushadie.designPatterns.createPatterns.FactoryPattern;

import cn.bushadie.designPatterns.rubbish.Food;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public interface FoodFactory {
    Food makeFood(String name);
}
