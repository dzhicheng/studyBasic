package com.dongzhic.design.patterns.observer.demo2;

/**
 * @Author dongzhic
 * @Date 3/21/21 1:27 AM
 */
public class Dad implements Observer {

    public void feed () {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}
