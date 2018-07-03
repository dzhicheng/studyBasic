package com.dongzhic.design.patterns.decorator.demo1;

/**
 * @author dongzc
 * @date 2018/7/3 14:50
 */
public interface Beverage {
    /**
     * 返回商品描述
     */
    String getDescription();

    /**
     * 返回价格
     */
    double getPrice();
}
