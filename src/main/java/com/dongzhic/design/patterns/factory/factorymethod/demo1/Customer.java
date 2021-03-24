package com.dongzhic.design.patterns.factory.factorymethod.demo1;

/**
 * @author dongzc
 * @date 2018/6/21 15:13
 */
public class Customer {

    public static void main(String[] args) {
        FactoryBMW factoryBMW320 = new FactoryBMW320();
        BMW bmw320 = factoryBMW320.createBMW();

        FactoryBMW factoryBMW523 = new FactoryBMW523();
        BMW bmw523 = factoryBMW523.createBMW();
    }
}
