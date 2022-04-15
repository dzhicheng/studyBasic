package com.dongzhic.java.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author dongzhic
 * @Date 2021/11/1 11:11
 */
public class StreamApp {

    public static void main(String[] args) {


        System.out.print(1);
        System.out.println(2);
        

        int[] array = new int[]{6, 5, 1 , 4, 5 ,9};
        // 这里的i可以代表数组某个位置
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }




//        List<Book> list = new ArrayList<>();
//        list.add(new Book("jvm虚拟机", 50.5));
//        list.add(new Book("jvm虚拟机", 30.5));
//        list.add(new Book("jvm虚拟机", 40.5));
//        list.add(new Book("重构：改善既有代码的设计", 60.0));
//        list.add(new Book("重构：改善既有代码的设计", 54.0));

        // 1.遍历
//        list.forEach(System.out::println);
        // 等同于
//        list.forEach(student -> {
//            System.out.println(student);
//        });

        // 2.过滤，分组，取价格最低的数据
//        Map<String, Book> map = list.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Book::getName,
//                                Collectors.collectingAndThen(
//                                        Collectors.reducing((b1, b2) -> b1.getPrice() < b2.getPrice() ? b1 : b2), Optional::get
//                                )
//                        )
//                );
//        List<Book> listSortAndGroup = new ArrayList<>(map.values());
//        listSortAndGroup.stream().forEach(System.out::println);
    }

    public void test (){

        try{
            int i = 100/ 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            throw new RuntimeException();
        }finally{
            System.out.print(2);
        }

        System.out.print(3);

    }

}
