package com.dongzhic.design.patterns.facade;

/**
 * 外观模式：前端
 * @Author dongzhic
 * @Date 3/20/21 3:49 PM
 */
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.opene();
    }
}
