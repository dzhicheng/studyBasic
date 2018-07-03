package com.dongzhic.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author dongzc
 * @date 2018/7/3 14:16
 */
@WebService
public class Hello {
    /**
     * 隐藏方法
     * @param name
     * @return
     */
    @WebMethod(exclude = true)
    public String sayHello (String name) {
        return "Hello，"+name;
    }
    /**
     * 暴露的方法
     * @param name
     * @return
     */
    public String sayHi (String name) {
        return "Hi"+ name;
    }
}
