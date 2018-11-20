package cn.bushadie.designPatterns.StructurePatterns.ProxyPattern;

import cn.bushadie.designPatterns.rubbish.Food;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public interface FoodService {
    Food makeChicken();
    Food makeNoodle();
}
