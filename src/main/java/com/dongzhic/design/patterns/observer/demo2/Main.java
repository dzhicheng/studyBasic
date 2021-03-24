package com.dongzhic.design.patterns.observer.demo2;

/**
 * @Author dongzhic
 * @Date 3/21/21 1:51 AM
 */
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "bed", child);
        child.wakeUp(wakeUpEvent);
    }
}
