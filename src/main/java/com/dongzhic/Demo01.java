package com.dongzhic;

import java.util.ArrayList;

/**
 * @Author dongzhic
 * @Date 6/23/21 6:43 PM
 */
public class Demo01 {

    public static void main(String[] args) {

    }

    /*
    * 请实现一个deleteFromArray方法，在arr删除指定数字，执行删除后，未删除数字的相对顺序不能变
    * 例如：arr=[4,5,3,1,6,3,9,3,2],target=3
    * 删除后结果：[4,5,1,6,9,2,*,*,*]，其中*代表任意值。
    * 返回值为删除后数组内有效数字个数，参数arr数组内要完成对应的数据移动。
    * 注意:只能使用ArrayList的get和set方法，remove，indexof等方法禁止使用，请在原数组操作，禁止申请新的数组。
    */
    //请在此处编写代码
    public static Integer deleteFromArray(ArrayList<Integer> arr, Integer target) {

        int left = 0;

        for (int right = 0; right < arr.size(); right ++) {

            if (arr.get(right) != target) {

                Integer temp = arr.get(right);
                arr.set(right, arr.get(left));
                arr.set(left ,temp);

                left++;
            }

        }



        return null;
    }



}
