package cn.bushadie.designPatterns.BehaviorPatterns.StrategyPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
