package com.dongzhic.datastructures.stack;

import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.array.ArrayList;

/**
 * 栈
 * @Author dongzhic
 * @Date 12/4/20 10:59 AM
 */
public class Stack<E>{


    private List<E> list = new ArrayList<>();

    public int size () {
        return list.size();
    }

    public boolean isEmpty () {
        return list.isEmpty();
    }

    /**
     * 入栈
     * @param element
     */
    public void push (E element) {
        list.add (element);
    }

    /**
     * 出栈
     * @return
     */
    public E pop () {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E top () {
        return list.get(list.size() - 1);
    }

    /**
     * 清空元素
     */
    public void clear () {
        list.clear();
    }
}
