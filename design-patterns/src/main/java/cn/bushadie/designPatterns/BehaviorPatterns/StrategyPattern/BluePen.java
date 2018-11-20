package cn.bushadie.designPatterns.BehaviorPatterns.StrategyPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
