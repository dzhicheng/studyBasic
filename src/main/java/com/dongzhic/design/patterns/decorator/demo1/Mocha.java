package com.dongzhic.design.patterns.decorator.demo1;

/**
 * @author dongzc
 * @date 2018/7/3 15:00
 */
public class Mocha extends Decorator {

    private String description = "加了摩卡！";
    private Beverage beverage = null;

    public Mocha (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    @Override
    public double getPrice() {
        return beverage.getPrice()+30;
    }
}
