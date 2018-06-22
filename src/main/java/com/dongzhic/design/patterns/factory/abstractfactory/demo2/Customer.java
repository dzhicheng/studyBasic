package com.dongzhic.design.patterns.factory.abstractfactory.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 14:42
 */
public class Customer {
    public static void main(String[] args) {
        AndroidFactory androidFactory = new AndroidFactory();
        OperationController androidOperationController = androidFactory.createOperationController();
        androidOperationController.control();
        UIController androidUIController = androidFactory.createUIController();
        androidUIController.display();

//        IosFactory iosFactory = new IosFactory();
//        iosFactory.createOperationController();
//        iosFactory.createUIController();
//
//        WpFactory wpFactory = new WpFactory();
//        wpFactory.createOperationController();
//        wpFactory.createUIController();
    }
}
