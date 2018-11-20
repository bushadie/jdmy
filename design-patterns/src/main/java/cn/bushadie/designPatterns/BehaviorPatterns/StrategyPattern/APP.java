package cn.bushadie.designPatterns.BehaviorPatterns.StrategyPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class APP {
    public static void main(String[] args) {
        Context context = new Context(new BluePen()); // 使用绿色笔来画
        context.executeDraw(10, 0, 0);
    }
}
