package com.dongzhic.java.io.randomaccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author dongzc
 * @date 2018/7/2 17:49
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        File file = new File("C:/Users/zhicheng/Desktop/1/create.txt");
        try {
            if (file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
            //指针位置
            System.out.println("初始指针位置："+accessFile.getFilePointer());
            accessFile.write('A');
            System.out.println(accessFile.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
