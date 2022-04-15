package com.dongzhic.java.generics;

import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.array.ArrayList;

/**
 * @Author dongzhic
 * @Date 6/21/21 10:47 AM
 */
public class A {

    public static void main(String[] args) {

        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();

//        listA = listB;
//        listB = listA;

    }
}

class B extends A {}
class C extends A {}


