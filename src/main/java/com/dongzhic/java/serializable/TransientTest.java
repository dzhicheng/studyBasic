package com.dongzhic.java.serializable;

import java.io.*;

/**
 * @author dongzhic
 * @date 2018.05.16
 */
public class TransientTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("zhicheng");
        user.setPassword("xiaodong123");

        System.out.println("read before Serializable: ");
        System.out.println("username: "+user.getName());
        System.out.println("password: "+user.getPassword());

        //将用户对象写入文件中
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取文件，生成用户对象
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:/user.txt"));
            user = (User) is.readObject();
            is.close();

            System.out.println("\n read after Serializable: ");
            System.out.println("username: "+user.getName());
            System.out.println("password: "+user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
