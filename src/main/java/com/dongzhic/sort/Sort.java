package com.dongzhic.sort;

/**
 * @Author dongzhic
 * @Date 2019-06-19 09:14
 */
public class Sort {

    public static void main(String[] args) {
        int [] array = {3,6,1,4,2};
        int[] a = insertionSort(array);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort (int[] array) {

        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length-1; i ++) {
            for (int j = 0; j < array.length - 1 - i; j ++) {
                if (array[j] > array [j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 简单选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort (int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j ++ ) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertionSort (int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i ++) {
            current = array[i+1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return array;
    }

}
