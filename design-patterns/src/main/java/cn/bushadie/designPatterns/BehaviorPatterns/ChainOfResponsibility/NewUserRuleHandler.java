package cn.bushadie.designPatterns.BehaviorPatterns.ChainOfResponsibility;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class NewUserRuleHandler extends RuleHandler {

    public void apply(Context context) {
        if (context.isNewUser()) {
            // 如果有后继节点的话，传递下去
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("该活动仅限新用户参与");
        }
    }

}
