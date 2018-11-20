package cn.bushadie.designPatterns.BehaviorPatterns.ObserverPattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
