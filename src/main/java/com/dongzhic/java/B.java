package com.dongzhic.java;

/**
 * @author dongzhic
 */

class A {

    public A () {
        System.out.println("A");
    }
}

public class B extends A {

    public B () {
        System.out.println("B");
    }

    public static void main(String[] args) {
        A a = new B();
        a = new A();
    }
}
