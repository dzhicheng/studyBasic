package com.dongzhic.java.reflect.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author dongzc
 * @date 2018/6/26 15:21
 */
public class ClassUtil {

    /**
     * 打印类的信息：获取成员函数
     * @param obj
     */
    public static void printMethodMessage(Object obj){
        //获取类的信息，首先要获取类的类类型
        //传递的是那个子类的对象，c就是该子类的类类型
        Class c = obj.getClass();
        //获取类的名称
        System.out.println("类的名称"+c.getName());

        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods():获取的是所有的public函数，包含父类继承来的
         * getDeclaredMethods():获取的是所有该类自己声明的方法
         */
        Method[] ms = c.getDeclaredMethods();
        for (int i=0; i<ms.length; i++){
            //1.得到方法返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName()+" ");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取参数类型->>得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes ) {
                System.out.print(class1.getName()+", ");
            }
            System.out.println(")");
        }
    }

    /**
     * 打印类的信息：获取成员变量
     * @param obj
     */
    public static void printFieldMessage(Object obj) {
        //获取类的信息，首先要获取类的类类型
        //传递的是那个子类的对象，c就是该子类的类类型
        Class c = obj.getClass();
        //获取类的名称
        System.out.println("类的名称："+c.getName());

        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields()获取该类自己声明的成员变量的信息
         */
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            //成员变量类型的类类型
            Class fieldType = field.getType();
            String fieldTypeName = fieldType.getSimpleName();
            String fieldName = field.getName();
            System.out.println(fieldTypeName+" "+fieldName);
        }
    }

    /**
     * 打印构造函数的信息
     * @param obj
     */
    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println("类的名称为："+c.getName());

        Constructor[] cons = c.getConstructors();
        for (Constructor constructor : cons) {
            //1.获取构造器的名称
            System.out.print(constructor.getName()+"(");
            //2.获取构造器的入参类型的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class param : paramTypes) {
                //3.获取构造器入参类型的名称
                System.out.print(param.getName()+", ");
            }
            System.out.println(")");
        }
    }
}
