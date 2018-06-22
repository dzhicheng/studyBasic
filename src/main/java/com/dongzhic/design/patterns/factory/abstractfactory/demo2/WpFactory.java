package com.dongzhic.design.patterns.factory.abstractfactory.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 14:39
 */
public class WpFactory implements SystemFactory {
    public OperationController createOperationController() {
        return new WpOperationController();
    }

    public UIController createUIController() {
        return new WpUIController();
    }
}
