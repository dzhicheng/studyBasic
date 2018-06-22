package com.dongzhic.design.patterns.factory.abstractfactory.demo2;

/**
 * 抽象工厂
 * @author dongzc
 * @date 2018/6/22 14:30
 */
public interface SystemFactory {
    OperationController createOperationController ();
    UIController createUIController ();
}
