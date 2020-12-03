package com.dongzhic.datastructures.array;

import com.dongzhic.datastructures.List;

/**
 * @Author dongzhic
 * @Date 2020-11-04 15:46
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 获取数组的数量
     * @return
     */
    public int size () {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains (E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add (E element) {
        add(size, element);
    }

    /**
     * 数组越界判断
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 添加元素，数组越界判断
     * @param index
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    protected void outOfBounds (int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

}
