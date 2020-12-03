package com.dongzhic.datastructures;

/**
 * @Author dongzhic
 * @Date 2020-11-04 15:03
 */
public interface List<E> {

    /**
     * 元素未找到
     */
    int ELEMENT_NOT_FOUND = -1;

    /**
     * 清除所有元素
     */
    void clear ();

    /**
     * 获取数组的数量
     * @return
     */
    int size ();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty ();

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains (E element);

    /**
     * 添加元素到尾部
     * @param element
     */
    void add (E element);

    /**
     * 在index位置插入元素
     * @param index
     * @param element
     */
    void add (int index, E element) ;

    /**
     * 获取index位置元素
     * @param index
     * @return
     */
    E get (int index);

    /**s
     * 在index位置插入元素
     * @param index
     * @param element
     */
    E set (int index, E element);

    /**
     * 移除index位置元素
     * @param index
     * @return
     */
    E remove (int index);

    /**
     * 查看元素索引
     * @param element
     * @return
     */
    int indexOf (E element);

}
