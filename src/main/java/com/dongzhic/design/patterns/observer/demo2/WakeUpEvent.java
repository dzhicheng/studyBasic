package com.dongzhic.design.patterns.observer.demo2;

/**
 * 事件类 fire Event
 * @Author dongzhic
 * @Date 3/21/21 1:47 AM
 */
public class WakeUpEvent {

    /**
     * 时间
     */
    private long timestamp;
    /**
     * 地点
     */
    private String loc;
    private Child source;

    public WakeUpEvent (long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    public Child getSource () {
        return source;
    }
}
