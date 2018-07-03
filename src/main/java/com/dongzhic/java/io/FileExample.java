package com.dongzhic.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件
 * @author dongzc
 * @date 2018/7/2 9:50
 */
public class FileExample {

    public static void main(String[] args) {
        createFile();
    }

    public static void createFile () {
        File file = new File("C:/Users/zhicheng/Desktop/1/input.txt");
        FileOutputStream os = null;
        try {
            //判断文件的目录是否存在,不存在则创建
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();

            //写入内容
            os = new FileOutputStream(file);
            os.write("写入内容".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //必须关闭，否则容易导致内存泄漏，数据丢失
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
