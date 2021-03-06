package cn.bushadie.designPatterns.BehaviorPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 数据已变更，通知观察者们
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    // 通知观察者们
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
