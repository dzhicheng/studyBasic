package com.dongzhic.design.patterns.decorator.demo2;

/**
 * @author dongzc
 * @date 2018/7/4 11:13
 */
public class Condiment implements Pancake {

    private String desc = "我只是装饰器，不知道具体的描述";

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
