package com.dongzhic.sort;

/**
 * @Author dongzhic
 * @Date 2019-06-19 09:14
 */
public class Sort {

    public static void main(String[] args) {
//        int [] array = {4, 11, 2, 78, 10, 1};
        int [] array = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};

        binarySearch1(array, 21, 0, array.length-1);

    }


    /**
     * 二分查找：递归
     * @param array
     * @return
     */
    public static int binarySearch1 (int[] array, int key, int low, int high) {

        int result;

        int middle = (low+high)/2;

        if (array[middle] > key) {
            result = binarySearch1(array, key, low, middle - 1);
        } else if (array[middle] < key) {
            result = binarySearch1(array, key, middle + 1, high);
        } else {
            result = middle;
        }

        return result;
    }


    /**
     * 二分查找：while循环
     * @param array
     * @return
     */
    public static int binarySearch2 (int[] array, int key) {

        int low = 0;
        int high = array.length-1;

        while (low <= high) {

            int middle = (low + high)/2;

            if (array[middle] > key) {
                high = middle - 1;
            } else if (array[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }

        }

        return -1;
    }





    /**
     * 交换排序：冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort (int[] array) {

        if (array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length -1 - i; j ++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    /**
     * 交换排序：快速排序
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int[] quickSort (int[] array, int left, int right) {

        int l = left;
        int r = right;
        // 中轴值
        int pivot = array[(left + right)/2];

        while (l < r) {

            while (pivot > array[l]) {
                l++;
            }

            while (pivot < array[r]) {
                r --;
            }

            if (l >= r) {
                break;
            }

            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            //
            if (array[l] == pivot) {
                r --;
            }

            if (array[r] == pivot) {
                l ++  ;
            }

        }

        if (l == r) {
            l ++;
            r --;
        }

        if (left < r) {
            quickSort(array, left, r);
        }

        if (right > l) {
            quickSort(array, l, right);
        }

        return array;
    }

    /**
     * 插入排序：直接插入排序
     * @param array
     * @return
     */
    public static int[] insertTionSort (int[] array) {

        if (array.length == 0) {
            return array;
        }

        int current = 0;
        for (int i = 0; i < array.length -1; i ++) {

            current = array[i +1];
            int preIndex = i;

            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex+1] = array[preIndex];
                preIndex --;
            }

            array[preIndex+1] = current;
        }

        return array;

    }




}
