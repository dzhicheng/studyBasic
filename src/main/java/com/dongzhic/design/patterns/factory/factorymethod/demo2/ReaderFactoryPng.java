package com.dongzhic.design.patterns.factory.factorymethod.demo2;

/**
 * @author dongzc
 * @date 2018/6/22 10:46
 */
public class ReaderFactoryPng implements ReaderFactory {

    public BaseReader getReader() {
        return new ReaderPng();
    }
}
