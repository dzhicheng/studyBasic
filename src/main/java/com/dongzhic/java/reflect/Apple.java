package com.dongzhic.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * @Author dongzhic
 * @Date 2021/12/7 14:06
 */
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取Class对象的三种方式
     *  1 Class.forName("com.dongzhic.java.reflect.Apple")
     *  2 Apple.class
     *  3 apple.getClass()
     * @param args
     */
    public static void main(String[] args) {
        // 1.正常的调用
        Apple apple1 = new Apple();
        apple1.setPrice(10);
        System.out.println("Apple1 Price:" + apple1.getPrice());

        // 2.反射调用
        try {
            // 获取类的class对象实例
            Class clazz = Class.forName("com.dongzhic.java.reflect.Apple");
            // 根据class对象实例获取Constructor对象
            Constructor constructor = clazz.getConstructor();
            // 使用Constructor对象的newInstance方法获取反射类对象
            Object obj = constructor.newInstance();

            Method setMethod = clazz.getMethod("setPrice", int.class);
            setMethod.invoke(obj, 15);

            Method getMethod = clazz.getMethod("getPrice");
            System.out.println("Apple2 Price:" + getMethod.invoke(obj));
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
