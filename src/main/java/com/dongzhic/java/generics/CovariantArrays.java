package com.dongzhic.java.generics;

import com.dongzhic.datastructures.array.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * 通配符
 * @Author dongzhic
 * @Date 2021/9/28 10:40
 */
public class CovariantArrays {

    public static void main(String[] args) {

        // 数组的协变
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Orange();

        try {
            fruits[3] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fruits[4] = new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 上边界限定通配符
     */
    public void genericsAndCovariance () {

        /**
         * 无法编译，泛型不支持协变，
         *  尽管 Apple 是 Fruit 的子类型，
         *  但是 ArrayList<Apple> 不是 ArrayList<Fruit> 的子类型
         */
//        ArrayList<Fruit> fruitArrayList = new ArrayList<Apple>();

        // 做了泛型的向上转型,失去了向这个 List 添加任何对象的能力，即使是 Object 也不行。
        ArrayList<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Fruit());
//        flist.add(new Apple());
//        flist.add(new Orange());
        flist.add(null);



    }

    /**
     * 下边界限定通配符
     */
    public void superTypeWildcards (List<? super Apple> apples) {

        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Orange());

    }

    /**
     * src 是原始数据的 List，因为要从这里面读取数据，
     *      所以用了上边界限定通配符：<? extends T>，取出的元素转型为 T
     * dest 是要写入的目标 List，
     *      所以用了下边界限定通配符：<? super T>，可以写入的元素类型是 T 及其子类型
     * @param dest
     * @param src
     * @param <T>
     */
    public static <T> void copy (List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.set(i, src.get(i));
        }
    }

}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

