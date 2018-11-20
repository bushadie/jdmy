package cn.bushadie.designPatterns.BehaviorPatterns.StatusPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class RevertState implements State {
    public void doAction(Context context) {
        System.out.println("给此商品补库存");
        context.setState(this);

        //... 执行加库存的具体操作
    }
    public String toString() {
        return "Revert State";
    }
}
