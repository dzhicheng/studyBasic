package com.dongzhic.jvm;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 3/24/21 3:50 PM
 */
public class TestJDKClassLoader {

    public static void main(String[] args) {

        System.out.println(Map.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(TestJDKClassLoader.class.getClassLoader());

        System.out.println("================================================");
        System.out.println();

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapLoad = extClassLoader.getParent();
        System.out.println("the appClassLoader : " + appClassLoader);
        System.out.println("the extClassLoader : " + extClassLoader);
        System.out.println("the bootstrapLoad : " +  bootstrapLoad);

        System.out.println("================================================");
        System.out.println();
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i =0; i < urls.length; i ++) {
            System.out.println(urls[i]);
        }

        System.out.println();
        System.out.println("bootstrapLoader加载以下文件：");

        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));


    }
}
