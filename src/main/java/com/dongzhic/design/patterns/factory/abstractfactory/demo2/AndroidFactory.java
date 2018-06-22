package com.dongzhic.design.patterns.factory.abstractfactory.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 14:36
 */
public class AndroidFactory implements SystemFactory {
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }

    public UIController createUIController() {
        return new AndroidUIController();
    }
}
