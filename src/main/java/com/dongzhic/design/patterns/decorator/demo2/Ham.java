package com.dongzhic.design.patterns.decorator.demo2;

/**
 * @author dongzc
 * @date 2018/7/4 11:16
 */
public class Ham extends Condiment{

    private String desc = "火腿片";
    private Pancake pancake;

    public Ham(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "\n" +desc;
    }

    @Override
    public double getPrice() {
        return pancake.getPrice() + 1.5;
    }
}
