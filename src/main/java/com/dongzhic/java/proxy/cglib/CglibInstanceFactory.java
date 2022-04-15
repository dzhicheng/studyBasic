package com.dongzhic.java.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author dongzhic
 * @Date 7/12/21 4:05 PM
 */
public class CglibInstanceFactory {


    public static Object getInstance () {
        // 拿到字节码增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class);
        enhancer.setCallbackFilter(new CglibFilter());

        Callback[] callbacks = {new AddInterceptor(),
                new DelInterceptor(),
                new QueryInterceptor()};
        enhancer.setCallbacks(callbacks);

        return enhancer.create();
    }
}
