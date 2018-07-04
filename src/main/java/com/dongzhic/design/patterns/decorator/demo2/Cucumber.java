package com.dongzhic.design.patterns.decorator.demo2;

/**
 * @author dongzc
 * @date 2018/7/4 11:17
 */
public class Cucumber extends Condiment {

    private String desc = "黄瓜丝";
    private Pancake pancake;

    public Cucumber(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "\n" +desc;
    }

    @Override
    public double getPrice() {
        return pancake.getPrice()+0.5;
    }
}
