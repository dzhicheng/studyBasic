package com.dongzhic.sort;

/**
 * @Author dongzhic
 * @Date 5/24/21 6:24 PM
 */
public class SortApp {

    public static void main(String[] args) {
        int [] array = {3, 1, 2, 5, 4};

            quickSort(array, 0, array.length-1);
    }


    /**
     * 交换排序：冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort (int[] array) {

        if (array == null) {
            return null;
        }

        int len = array.length;
        for (int i = 0; i < len - 1; i ++) {
            for (int j = 0; j < len - 1 - i; j ++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    /**
     *
     * @param array
     * @param begin
     * @param end
     * @return
     */
    public static int[] quickSort (int[] array, int begin, int end) {

        if (array == null || array.length == 1 || begin >= end) {
            return array;
        }

        int low = begin;
        int high = end;
        // 基准数
        int pivot = array[begin];

        while (low < high) {

            // 从右边检索比基准数小的
            while (low < high && array[high] >= pivot) {
                high--;
            }
            // 从左边检索比基准数大的
            while (low < high && array[low] <= pivot) {
                low++;
            }

            // 交换元素
            swap(array, low, high);

        }

        // 交换基准数
        array[begin] = array[low];
        array[low] = pivot;

        // 左部分排序
        quickSort(array, begin, low - 1);
        // 右部分排序
        quickSort(array, low + 1, end);

        return array;
    }

    /**
     * 交换数组中两个元素位置
     * @param array
     * @param i
     * @param j
     * @return
     */
    public static int[] swap (int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return array;
    }
}
