package com.dongzhic.design.patterns.decorator.demo1;

/**
 * @author dongzc
 * @date 2018/7/3 14:56
 */
public class Milk extends Decorator {

    private String description = "加了牛奶!";
    private Beverage beverage = null;

    public Milk (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 20;
    }
}
