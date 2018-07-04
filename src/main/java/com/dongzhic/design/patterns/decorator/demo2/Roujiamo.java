package com.dongzhic.design.patterns.decorator.demo2;

/**
 * 肉夹馍
 * @author dongzc
 * @date 2018/7/4 11:10
 */
public class Roujiamo implements Pancake{

    private String desc = "肉夹馍";

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public double getPrice() {
        return 6;
    }
}
