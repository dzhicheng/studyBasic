package com.dongzhic.datastructures.link;

import com.dongzhic.datastructures.array.AbstractList;

/**
 * 单向链表：虚拟头结点
 * @Author dongzhic
 * @Date 2020-10-28 17:02 SubList
 */
public class SingleLinkedList2<E> extends AbstractList<E> {

    private Node<E> first;

    /**
     * 元素未找到
     */
    private static final int ELEMENT_NOT_FOUND = -1;

    public SingleLinkedList2() {
        first = new Node<>(null, null);
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    public E set (int index, E element) {

        Node<E> node = getNode(index);
        E old = node.element;
        node.element = element;

        return old;
    }

    @Override
    public E remove(int index) {

        rangeCheck(index);

        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = getNode(index -1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element ;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i ++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i ++) {
                if (element.equals(first.next)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) == ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {

        rangeCheckForAdd(index);

        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = getNode(index-1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    public void clear () {
        size = 0;
        first = null;
    }

    /**
     * 获取index节点对应对象
     * @param index
     * @return
     */
    private Node<E> getNode (int index) {
        rangeCheck(index);

        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 获取index对应节点对象
     * @param <E>
     */
    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("size = ").append( + size).append(", [");

        Node<E> node = first;
        for (int i = 0; i < size; i ++) {
            if (i != 0) {
                str.append(",");
            }
            str.append(node.element);
            node = node.next;
        }
        str.append("]");

        return str.toString();
    }
}
