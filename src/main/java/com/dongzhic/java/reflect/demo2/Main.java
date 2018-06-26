package com.dongzhic.java.reflect.demo2;

/**
 * @author dongzc
 * @date 2018/6/26 16:57
 */
public class Main {
    public static void main(String[] args) {
        String a = "abc";
        ClassUtil.printMethodMessage(a);
        System.out.println("=============================");
        ClassUtil.printFieldMessage(a);
        System.out.println("=============================");
        ClassUtil.printConMessage(a);
    }
}
