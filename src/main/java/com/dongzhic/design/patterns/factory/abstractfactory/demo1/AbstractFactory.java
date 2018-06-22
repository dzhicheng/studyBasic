package com.dongzhic.design.patterns.factory.abstractfactory.demo1;

/**
 * 工厂类接口
 * @author dongzc
 * @date 2018/6/21 15:54
 */
public interface AbstractFactory {
    /**
     * 制造发动机
     * @return
     */
    BaseEngine createEngine();

    /**
     * 制造空调
     * @return
     */
    BaseAircondition createAircondition();
}
