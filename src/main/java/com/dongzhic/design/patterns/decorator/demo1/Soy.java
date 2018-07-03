package com.dongzhic.design.patterns.decorator.demo1;

/**
 * @author dongzc
 * @date 2018/7/3 15:00
 */
public class Soy extends Decorator {

    private String description = "加了豆浆!";
    private Beverage beverage = null;

    public Soy (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +"\n" + description;
    }

    @Override
    public double getPrice() {
        return beverage.getPrice()+10;
    }
}
