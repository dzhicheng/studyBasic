package com.dongzhic.design.patterns.decorator.demo2;

/**
 * @author dongzc
 * @date 2018/7/4 11:21
 */
public class App {

    public static void main(String[] args) {
        Pancake pancake = new Roujiamo();
        pancake = new Ham(pancake);
        pancake = new FiredEgg(pancake);
        pancake = new Cucumber(pancake);
        System.out.println(pancake.getDesc()+", 价格为："+pancake.getPrice());
    }
}
