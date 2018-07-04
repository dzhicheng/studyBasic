package com.dongzhic.design.patterns.decorator.demo2;

/**
 * @author dongzc
 * @date 2018/7/4 11:17
 */
public class MeatFloss extends Condiment {

    private String desc = "肉松";
    private Pancake pancake;

    public MeatFloss(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "\n" + desc;
    }

    @Override
    public double getPrice() {
        return pancake.getPrice() + 1;
    }
}
