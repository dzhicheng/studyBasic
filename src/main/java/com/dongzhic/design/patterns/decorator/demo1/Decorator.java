package com.dongzhic.design.patterns.decorator.demo1;

/**
 * 装饰类
 * @author dongzc
 * @date 2018/7/3 14:55
 */
public class Decorator implements Beverage{

    private String description = "我只是装饰器，不知道具体的描述";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
