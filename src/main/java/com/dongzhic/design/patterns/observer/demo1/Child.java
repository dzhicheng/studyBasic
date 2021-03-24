package com.dongzhic.design.patterns.observer.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongzhic
 * @Date 3/21/21 1:30 AM
 */
public class Child {

    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public boolean isCry () {
        return cry;
    }

    public void wakeUp () {
        cry = true;
        for (Observer o : observers) {
            o.actionOnWakeUp();
        }
    }

}
