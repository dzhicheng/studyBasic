package com.dongzhic.java.thread;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhic
 * @Date 3/11/21 11:42 AM
 */
public class ReferenceTest {

    public static void main(String[] args) {

        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

//        HashMap hashMap = null;
//        Hashtable
//        Collections.synchronizedMap()
//        ConcurrentHashMap

    }

    /**
     * 强引用：不会被回收
     */
    public void normalReference() {
        try {
            // 强引用
            M m = new M();
            m = null;
            System.gc();
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 软引用：内存不足就回收
     */
    public void softReference () {
        // 存放10M
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 12]);
        System.out.println(m.get());
        System.gc();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
    }

    /**
     * 弱引用：遇到gc就回收
     */
    public void weakReference () {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        // null
        System.out.println(m.get());
    }
}
class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收！！！");
    }
}
