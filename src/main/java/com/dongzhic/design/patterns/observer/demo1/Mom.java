package com.dongzhic.design.patterns.observer.demo1;

/**
 * @Author dongzhic
 * @Date 3/21/21 1:28 AM
 */
public class Mom implements Observer {

    /**
     * 抱抱
     */
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}
