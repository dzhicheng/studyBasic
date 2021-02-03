package com.dongzhic.datastructures;

import com.dongzhic.datastructures.queue.Queue;

/**
 * @Author dongzhic
 * @Date 1/8/21 4:35 PM
 */
public class QueueApp {

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
