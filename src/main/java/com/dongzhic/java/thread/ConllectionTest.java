package com.dongzhic.java.thread;

import java.util.Hashtable;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author dongzhic
 * @Date 3/11/21 5:41 PM
 */
public class ConllectionTest {

    static Hashtable<UUID, UUID> m = new Hashtable<>();

    static int count = Constants.COUNT;
    static UUID[] keys = new UUID[count];

    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.poll();
    }

}
