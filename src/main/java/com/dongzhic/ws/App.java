package com.dongzhic.ws;

import javax.xml.ws.Endpoint;

/**
 * @author dongzc
 * @date 2018/7/3 14:16
 */
public class App {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9090/hailiang", new Hello());
    }
}
