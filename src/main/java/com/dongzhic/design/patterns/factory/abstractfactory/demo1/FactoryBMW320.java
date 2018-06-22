package com.dongzhic.design.patterns.factory.abstractfactory.demo1;

/**
 * 工厂类：为宝马320系列生产配件
 * @author dongzc
 * @date 2018/6/21 15:58
 */
public class FactoryBMW320 implements AbstractFactory {

    public BaseEngine createEngine() {
        return new EngineA();
    }

    public BaseAircondition createAircondition() {
        return new AirconditionA();
    }
}
