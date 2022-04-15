package com.dongzhic.java.generics;

import java.util.Objects;

/**
 * @Author dongzhic
 * @Date 2021/9/28 11:05
 */
public class Holder<T> {

    private T value;

    public Holder(){}
    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple d = appleHolder.getValue();
        appleHolder.setValue(d);

        // Cannot upcast
//        Holder<Fruit> fruitHolder = appleHolder;

        Holder<? extends Fruit> fruitHolder = appleHolder;
        Fruit p = fruitHolder.getValue();
        d = (Apple) fruitHolder.getValue();

        try {
            Orange orange = (Orange) fruitHolder.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
