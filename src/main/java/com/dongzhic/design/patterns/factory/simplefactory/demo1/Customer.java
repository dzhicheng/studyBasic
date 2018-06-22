package com.dongzhic.design.patterns.factory.simplefactory.demo1;

/**
 * @author dongzc
 * @date 2018/6/21 14:44
 */
public class Customer {

    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
