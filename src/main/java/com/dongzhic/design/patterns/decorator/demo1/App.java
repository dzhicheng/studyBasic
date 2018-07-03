package com.dongzhic.design.patterns.decorator.demo1;

/**
 * @author dongzc
 * @date 2018/7/3 16:05
 */
public class App {

    public static void main(String[] args) {
        Beverage beverage = new CoffeeBean1();
//        beverage = new CoffeeBean2();
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);

        System.out.println(beverage.getDescription()+", 价格为："+beverage.getPrice());

    }
}
