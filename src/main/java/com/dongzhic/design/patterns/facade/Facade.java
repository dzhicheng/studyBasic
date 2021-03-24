package com.dongzhic.design.patterns.facade;

/**
 * 门面角色
 * @Author dongzhic
 * @Date 3/20/21 3:44 PM
 */
public class Facade {

    private Light l1,l2,l3;
    private Heater heater;
    private TV tv;

    public Facade () {
        l1 = new Light();
        l2 = new Light();
        l3 = new Light();
        heater = new Heater();
        tv = new TV();
    }

    public void opene () {
        l1.open();
        l2.open();
        l3.open();
        heater.open();
        tv.open();
    }
}
