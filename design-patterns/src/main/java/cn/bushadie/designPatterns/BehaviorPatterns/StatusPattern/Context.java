package cn.bushadie.designPatterns.BehaviorPatterns.StatusPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class Context {
    private State state;
    private String name;
    public Context(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return this.state;
    }
}
