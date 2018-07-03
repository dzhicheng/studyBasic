package com.dongzhic.java.io;

import com.dongzhic.java.io.entity.Student;

import java.io.*;

/**
 * 读写对象：ObjectInputStream 和ObjectOutputStream
 * @author dongzc
 * @date 2018/7/2 11:50
 */
public class ObjetStream {

    public static void main(String[] args) {
        ObjectOutputStream os = null;
        ObjectInputStream is = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("C:/Users/zhicheng/Desktop/1/student.txt"));
            os.writeObject(new Student("gg", 12));
            os.writeObject(new Student("tt", 14));
            os.writeObject(new Student("rr", 16));
            is = new ObjectInputStream(new FileInputStream("C:/Users/zhicheng/Desktop/1/student.txt"));
            for (int i=0; i < 3; i++) {
                System.out.println(is.readObject());
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
