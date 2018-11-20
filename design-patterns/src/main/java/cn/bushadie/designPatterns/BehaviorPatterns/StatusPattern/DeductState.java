package cn.bushadie.designPatterns.BehaviorPatterns.StatusPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class DeductState implements State {

    public void doAction(Context context) {
        System.out.println("商品卖出，准备减库存");
        context.setState(this);

        //... 执行减库存的具体操作
    }

    public String toString(){
        return "Deduct State";
    }
}
