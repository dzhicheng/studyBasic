package com.dongzhic.java;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author dongzhic
 * @Date 6/21/21 7:38 PM
 */
class Super {
    public int getLength() {
        return 4;
    }
}

public class Sub extends Super {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(5);

        System.out.println("未删除前：" + list);


        List<Integer> result = list.stream().filter( (Integer val) ->
            val != 2
        ).collect(Collectors.toList());

        System.out.println("删除后：" + result);



//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() == 2) {
//                iterator.remove();
//            }
//        }



    }
}


