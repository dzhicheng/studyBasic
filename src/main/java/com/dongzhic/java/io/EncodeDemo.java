package com.dongzhic.java.io;

/**
 * @author dongzc
 * @date 2018/7/2 14:51
 */
public class EncodeDemo {

    public static void main(String[] args) {
        String a = "你好，ab";
        byte[] byte1 = a.getBytes();
        for (byte b : byte1) {
            System.out.print(Integer.toHexString(b) +" ");
        }

    }
}
