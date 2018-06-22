package com.dongzhic.design.patterns.factory.abstractfactory.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 14:38
 */
public class IosFactory implements SystemFactory {
    public OperationController createOperationController() {
        return new IosOperationController();
    }

    public UIController createUIController() {
        return new IosUIController();
    }
}
