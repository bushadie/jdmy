package cn.bushadie.designPatterns.BehaviorPatterns.ChainOfResponsibility;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public abstract  class RuleHandler {
    // 后继节点
    protected RuleHandler successor;

    public abstract void apply(Context context);

    public void setSuccessor(RuleHandler successor) {
        this.successor = successor;
    }
    public RuleHandler getSuccessor() {
        return successor;
    }


}
