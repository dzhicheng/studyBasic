package com.dongzhic.java.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * Description:
 *
 * @author: dongzhic
 * @date: 2018/5/24 16:53
 */
public class GuavaCacheTest {

    public static void main(String[] args) throws ExecutionException {

        LoadingCache<String,String> cahceBuilder = CacheBuilder.newBuilder()
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue = "hello "+ key +"!";
                        return strProValue;
                    }
        });
        System.out.println("jerry value:"+cahceBuilder.apply("jerry"));
        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
        System.out.println("peida value:"+cahceBuilder.get("peida"));
        System.out.println("peida value:"+cahceBuilder.apply("peida"));
        System.out.println("lisa value:"+cahceBuilder.apply("lisa"));

    }


}
