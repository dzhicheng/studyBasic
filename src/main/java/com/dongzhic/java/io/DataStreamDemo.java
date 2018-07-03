package com.dongzhic.java.io;

import com.dongzhic.java.io.entity.Member;
import com.sun.xml.internal.ws.api.model.MEP;

import java.io.*;

/**
 * @author dongzc
 * @date 2018/7/2 12:04
 */
public class DataStreamDemo {

    public static void main(String[] args) {
        Member[] members = {new Member("gg", 10),
                            new Member("tt",12),
                            new Member("rr", 14)};
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        try {
            outputStream = new DataOutputStream(new FileOutputStream(args[0]));
            for (Member member : members) {
                outputStream.writeUTF(member.getName());
                outputStream.writeInt(member.getAge());
            }
            outputStream.flush();
            outputStream.close();

            inputStream = new DataInputStream(new FileInputStream(args[0]));
            for (int i=0; i<members.length; i++) {
                String name = inputStream.readUTF();
                int age = inputStream.readInt();
                members[i] = new Member(name, age);
            }
            inputStream.close();

            //显示还原后的数据
            for(Member member : members) {
                System.out.printf("%s\t%d%n",member.getName(),member.getAge());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                outputStream.close();
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }
}
