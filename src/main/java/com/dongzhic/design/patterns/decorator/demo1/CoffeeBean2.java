package com.dongzhic.design.patterns.decorator.demo1;

/**
 * 具体被装饰的对象类2
 * @author dongzc
 * @date 2018/7/3 14:54
 */
public class CoffeeBean2 implements Beverage {

    private String description = "第二种咖啡豆";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 10.5;
    }
}
