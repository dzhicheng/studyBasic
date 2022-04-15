package com.dongzhic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 6/22/21 11:10 PM
 */
public class PersonDemo {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        Map<Integer, Person> map = new HashMap<>();
        for (Person person : list) {
            int ageKey = person.getAge();
            Person oldPerson = map.get(ageKey);
            if (map.containsKey(ageKey)) {
                if (person.getHeight() != oldPerson.getHeight()) {
                    if (person.getHeight() > oldPerson.getHeight()) {
                        map.put(ageKey, person);
                    }
                } else {
                    if (person.getId() > oldPerson.getId()) {
                        map.put(ageKey, person);
                    }
                }

            } else {
                map.put(ageKey, person);
            }
        }

        List<Person> result = new ArrayList<>(map.size());
        for (Person person : map.values()) {
            result.add(person);
        }


    }



}

class Person {
    private int id;
    private int age;
    private int height;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
