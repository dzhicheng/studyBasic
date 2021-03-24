package com.dongzhic.design.patterns.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 适配器模式
 * @Author dongzhic
 * @Date 3/20/21 5:10 PM
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // inputStream
        FileInputStream fis = new FileInputStream("/usr/local/abc.txt");

        // inputStream转换reader
        InputStreamReader isr = new InputStreamReader(fis);

        // reader
        BufferedReader br = new BufferedReader(isr);

        String line = br.readLine();
        while (line != null && !"".equals(line)) {
            System.out.println(line);
        }

        br.close();
    }

}