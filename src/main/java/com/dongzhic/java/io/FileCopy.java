package com.dongzhic.java.io;

import java.io.*;

/**
 * Java I/O默认是不缓冲流的，所谓“缓冲”就是先把从流中得到的一块字节序列暂存在一个被称为buffer的内部字节数组里
 * 然后可以一下子取到这一整块的字节数据，没有缓冲的流只能一个字节一个字节读，效率孰高孰低一目了然
 * @author dongzc
 * @date 2018/7/2 11:18
 */
public class FileCopy {

    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        int numRead = 0;

        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(new File("C:/Users/zhicheng/Desktop/1/input.txt"));
            os = new FileOutputStream(new File("C:/Users/zhicheng/Desktop/1/out.txt"));

            while ((numRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, numRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
