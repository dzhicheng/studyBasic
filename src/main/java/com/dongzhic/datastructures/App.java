package com.dongzhic.datastructures;

import com.dongzhic.datastructures.link.CircleLinkedList;

/**
 * @Author dongzhic
 * @Date 2020-10-20 17:21
 */
public class App {

    public static void main(String[] args) {



    }

    /**
     * 约瑟夫问题
     */
    public void josephus () {
        //
        CircleLinkedList list = new CircleLinkedList();

        for (int i = 0; i < 10; i ++ ) {
            list.add(i);
        }

        // 指向头结点
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }
}
