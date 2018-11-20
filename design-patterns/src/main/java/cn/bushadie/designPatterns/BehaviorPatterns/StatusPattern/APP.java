package cn.bushadie.designPatterns.BehaviorPatterns.StatusPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class APP {
    public static void main(String[] args) {
        // 我们需要操作的是 iPhone X
        Context context = new Context("iPhone X");

        // 看看怎么进行补库存操作
        State revertState = new RevertState();
        revertState.doAction(context);

        // 同样的，减库存操作也非常简单
        State deductState = new DeductState();
        deductState.doAction(context);

        // 如果需要我们可以获取当前的状态
        // context.getState().toString();
    }
}
