package com.dongzhic.design.patterns.observer.demo2;

/**
 * 观察者接口
 * @Author dongzhic
 * @Date 3/21/21 1:26 AM
 */
public interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}