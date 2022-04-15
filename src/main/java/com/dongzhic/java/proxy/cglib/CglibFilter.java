package com.dongzhic.java.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @Author dongzhic
 * @Date 7/12/21 4:23 PM
 */
public class CglibFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {

        if ("add".equals(method.getName())) {
            return 0;
        } else if ("del".equals(method.getName())) {
            return 1;
        } else if ("query".equals(method.getName())) {
            return 2;
        } else {
            return 0;
        }

    }
}
