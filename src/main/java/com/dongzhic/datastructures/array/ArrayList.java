package com.dongzhic.datastructures.array;

import org.omg.CORBA.Object;

/**
 * @Author dongzhic
 * @Date 2020-10-19 16:04
 */
public class ArrayList<E> extends AbstractList<E>{


    /**
     * 所有元素
     */
    private E[] elements;

    /**
     * 默认容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList (int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取index位置元素
     * @param index
     * @return
     */
    public E get (int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**s
     * 在index位置插入元素
     * @param index
     * @param element
     */
    public E set (int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 查看元素索引
     * @param element
     * @return
     */
    public int indexOf (E element) {
        if (element == null) {
            for (int i = 0; i < size; i ++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i ++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清除所有元素
     */
    public void clear () {
        for (int i = 0; i < size; i ++) {
            elements[i] = null;
        }
        size = 0;

        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }

    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("size = ").append( + size).append(", [");

        for (int i = 0; i < size; i ++) {
            if (i != 0) {
                str.append(",");
            }
            str.append(elements[i]);
        }
        str.append("]");

        return str.toString();
    }

    /**
     * 移除index位置元素
     * @param index
     * @return
     */
    public E remove (int index) {

        rangeCheck(index);

        E old = elements[index];

        for (int i = index; i < size; i ++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 在index位置插入元素
     * @param index
     * @param element
     */
    public void add (int index, E element) {

        // 数组越界判断
        rangeCheckForAdd(index);
        // 判断容量是否足够
        ensureCapacity(size + 1);

        for (int i = size; i > index; i --) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;

        size++;

    }

    /**
     * 保证要有capacity容量
     * @param capacity
     */
    public void ensureCapacity (int capacity) {

        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        // 新容量是旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    /**
     * 缩容
     */
    public void trim () {
        int capacity = elements.length;
        int newCapacity = capacity >> 1;

        if (size >= newCapacity || capacity <= DEFAULT_CAPACITY) {
            return;
        }

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newElements[i] = elements[i];
        }

        elements = newElements;

        System.out.println(capacity + "，缩容为：" + newCapacity);
    }
}
