package com.dongzhic.java.io;

import java.io.*;

/**
 * 字节流：输入流InputStream
 * @author dongzc
 * @date 2018/7/2 10:50
 */
public class FileCount {

    public static void main(String[] args) {

        int count = 0;
        InputStream is = null;
        try {
            is = new FileInputStream(new File("C:/Users/zhicheng/Desktop/1/create.txt"));
            while (is.read() != -1){
                count++;
            }
            System.out.println("长度为:"+count+"字节");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //FileInputStream有缓冲区，用完之后必须关闭，
                //否则导致内存泄漏，数据丢失
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
