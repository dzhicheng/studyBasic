package com.dongzhic.design.patterns.factory.abstractfactory.demo1;

/**
 * @author dongzc
 * @date 2018/6/21 16:04
 */
public class FactoryBMW523 implements AbstractFactory {
    public BaseEngine createEngine() {
        return new EngineB();
    }

    public BaseAircondition createAircondition() {
        return new AirconditionB();
    }
}
