package com.dongzhic.java.reflect.demo2;

/**
 * @author dongzc
 * @date 2018/6/25 16:23
 */
public class ClassDemo1 {

    public static void main(String[] args) {

        //普通实例对象表现形式
        Foo foo = new Foo();
        //任何一个类都是Class的实例对象，这个实例对象有3种表示方式

        //1、已知类名：任何一个类都有一个隐含的静态成员变量class
        Class foo1 = Foo.class;

        //2、已知类的对象,通过getClass()方法获取
        Class foo2 = foo.getClass();

        /**
         * 官网foo1,foo2表示Foo类的类类型（class type）
         *
         * foo1和foo2都代表Foo类的类类型，一个类只可能是Class类的一个实例对象
         */
        System.out.println(foo1 == foo2);

        //3、通过类路径
        Class foo3 = null;
        try {
            foo3 = Class.forName("com.dongzhic.java.reflect.demo2.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(foo2 == foo3);

        //通过类的类类型创建该类的对象实例：通过foo1,foo2,foo3创建Foo的实例
        try {
            //需要无参构造方法,foo1,foo2,foo3可通过newInstance()方法
            Foo foo4 = (Foo) foo1.newInstance();
            foo4.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
