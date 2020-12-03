package com.dongzhic.datastructures.link;

import com.dongzhic.datastructures.array.AbstractList;

/**
 * 双向链表
 * @Author dongzhic
 * @Date 2020-10-28 17:02 SubList
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;


    /**
     * 元素未找到
     */
    private static final int ELEMENT_NOT_FOUND = -1;

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


        Node<E> node = getNode(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        // 删除首结点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        // 删除尾结点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
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

        if (index == size) {

            Node<E> oldLast = last;

            last = new Node<>(oldLast, element, null);

            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = getNode(index);
            Node<E> prev = next.prev;

            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;

            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }

        size++;
    }

    /**
     * 清空链表
     */
    public void clear () {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * 获取index节点对应对象
     * @param index
     * @return
     */
    private Node<E> getNode (int index) {
        rangeCheck(index);

        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i ++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i --) {
                node = node.prev;
            }
        }
        return node;
    }

    /**
     * 获取index对应节点对象
     * @param <E>
     */
    private static class Node<E> {

        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
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
