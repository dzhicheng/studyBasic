package com.dongzhic.test;

import java.util.Scanner;

/**
 * @Author dongzhic
 * @Date 2021/10/27 20:53
 */
public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    public int minLength (int n, int[][] nums) {




        return 0;
    }
}
