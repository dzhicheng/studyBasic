package com.dongzhic.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @Author dongzhic
 * @Date 3/24/21 6:50 PM
 */
public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {

        new Thread().start();

        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载 器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("/Users/zhicheng/");

        //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz = classLoader.loadClass("com.dongzhic.jvm.User");
        Object obj = clazz.newInstance();
        Method method =  clazz.getDeclaredMethod("sout", null);

        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }


    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                if (!name.startsWith("com.dongzhic.jvm")) {
                    c = this.getParent().loadClass(name);
                }
                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }



    private byte[] loadByte(String name) throws Exception {

        name = name.replaceAll("\\.", "/");

        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");


        int len = fis.available();

        byte[] data = new byte[len];

        fis.read(data);
        fis.close();

        return data;

    }


    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {

            byte[] data = loadByte(name);

            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节 数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

}
