package com.dongzhic.design.patterns.decorator.demo2;

/**
 * 手抓饼
 * @author dongzc
 * @date 2018/7/4 11:10
 */
public class TornCake implements Pancake{

    private String desc = "手抓饼";

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public double getPrice() {
        return 4;
    }
}
