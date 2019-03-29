package com.dongzhic.datastructures.array;

/**
 * 数组类
 * @author dongzhic
 */
public class Array {

    /**
     * 存放数组元素
     */
    private int[] data;
    /**
     * 数组存放元素大小
     */
    private int size;

    public Array (int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array () {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     */
    public int getSize () {
        return size;
    }

    /**
     * 获取取数的容量
     */
    public int getCapacity () {
        return data.length;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty () {
        return size == 0;
    }


}
