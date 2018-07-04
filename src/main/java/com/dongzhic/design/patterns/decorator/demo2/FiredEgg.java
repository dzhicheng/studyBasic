package com.dongzhic.design.patterns.decorator.demo2;

/**
 * @author dongzc
 * @date 2018/7/4 11:14
 */
public class FiredEgg extends Condiment {

    private String desc = "煎蛋";
    private Pancake pancake;

    public FiredEgg(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "\n" +desc;
    }

    @Override
    public double getPrice() {
        return pancake.getPrice()+2;
    }
}
