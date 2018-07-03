package com.dongzhic.design.patterns.decorator.demo1;

/**
 * 具体被装饰的对象类1
 * @author dongzc
 * @date 2018/7/3 14:52
 */
public class CoffeeBean1 implements Beverage {

    private String description = "选了第一种咖啡豆";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 4.5;
    }
}
