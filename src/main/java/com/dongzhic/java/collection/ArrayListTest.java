package com.dongzhic.java.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dongzhic
 */
public class ArrayListTest {

    public static void main(String[] args) {

        Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());

        sortUserList();

//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("1");
//        list.add("3");
//        list.add("4");
////        Iterator<String> iterator = list.iterator();
////        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
////        }
//
//        Map<String, Object> map = new HashMap<String, Object>(16);
//
//        map.put("1","一");
//        map.put("2","二");
//        map.put("3","三");
//        map.put("4","四");
//
//        Set<String> keySet = map.keySet();
//        //1、使用迭代器
////        Iterator<String> iterator = keySet.iterator();
////        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
////        }
//        //2、使用foreach遍历
//        for (String key : keySet) {
//            System.out.println(map.get(key));
//        }
//
//
//        HashSet hashSet = new HashSet();




    }

    /**
     * 将List中的User按照age排序
     */
    public static void sortUserList () {

        List<User> users = new ArrayList<>();
        User user1 = new User("dzc03", 3);
        User user2 = new User("dzc01", 1);
        User user3 = new User("dzc04", 4);
        User user4 = new User("dzc02", 2);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println("排序前：" + users);

        // 方法一：User继承Comparable类，实现compareTo方法
//        Collections.sort(users);

        // 方法二：
//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        // Lambda表达式
//        Collections.sort(users, (User o1, User o2) -> o1.getAge().compareTo(o2.getAge()) );
//        users.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));


        // 方式三
        users = users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("排序后：" + users);


    }


}
