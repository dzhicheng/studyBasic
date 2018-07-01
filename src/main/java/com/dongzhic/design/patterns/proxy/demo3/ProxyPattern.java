package com.dongzhic.design.patterns.proxy.demo3;

/**
 * @author dongzc
 * @date 2018/6/29 19:15
 */
public class ProxyPattern {

    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.buyMac();
    }
}
