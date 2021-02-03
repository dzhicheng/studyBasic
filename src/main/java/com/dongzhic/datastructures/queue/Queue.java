package com.dongzhic.datastructures.queue;

import com.dongzhic.datastructures.List;
import com.dongzhic.datastructures.link.LinkedList;

/**
 * @Author dongzhic
 * @Date 1/8/21 4:12 PM
 */
public class Queue<E> {

    private List<E> list = new LinkedList();


    /**
     * 队列元素的数量
     * @return
     */
    public int size () {

        return list.size();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty () {
        return list.isEmpty();
    }

    /**
     * 添加元素：入队
     * @param element
     */
    public void enQueue (E element) {
        list.add(element);
    }

    /**
     * 删除元素：出队
     * @return
     */
    public E deQueue () {
        return list.remove(0 );
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front () {
        return list.get(0);
    }

}
