package com.dongzhic.design.patterns.factory.abstractfactory.demo1;

/**
 * @author dongzc
 * @date 2018/6/21 16:43
 */
public class Customer {

    public static void main(String[] args) {
        //生产宝马320系列配件
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createEngine();
        factoryBMW320.createAircondition();

        //生产宝马523系列配件
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngine();
        factoryBMW523.createAircondition();
    }

}
