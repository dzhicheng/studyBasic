package com.dongzhic.design.patterns.factory.factorymethod.demo2;


/**
 * @author dongzc
 * @date 2018/6/22 10:50
 */
public class Customer {

    public static void main(String[] args) {
        ReaderFactoryGif gifFactory = new ReaderFactoryGif();
        BaseReader gif = gifFactory.getReader();
        gif.read();
    }
}
