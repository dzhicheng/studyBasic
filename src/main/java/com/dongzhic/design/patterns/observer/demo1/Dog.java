package com.dongzhic.design.patterns.observer.demo1;

/**
 * @Author dongzhic
 * @Date 3/21/21 1:29 AM
 */
public class Dog implements Observer {

    public void wang () {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}
