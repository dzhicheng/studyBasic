package com.dongzhic.redis;

import redis.clients.jedis.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dongzc
 * @date 2018/8/12 16:02
 */
public class JedisTest {

    private static final String IP = "60.60.1.90";
    private static final int PORT = 6380;

    public static void main(String[] args) {



    }

    /**
     * 集群
     */
    public void cluster () {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("104.155.205.150", 8001));
        jedisClusterNode.add(new HostAndPort("34.80.241.200", 8002));
        jedisClusterNode.add(new HostAndPort("35.201.252.85", 8003));
        jedisClusterNode.add(new HostAndPort("104.155.205.150", 8004));
        jedisClusterNode.add(new HostAndPort("34.80.241.200", 8005));
        jedisClusterNode.add(new HostAndPort("35.201.252.85", 8006));

        JedisCluster jedisCluster = null;
        try {
            jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, "dong", config);
            System.out.println(jedisCluster.set("user:102", "dzc"));
            System.out.println(jedisCluster.get("user:102"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisCluster != null) {
                try {
                    jedisCluster.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void demo01 () {
        String key = "name";
        // 1.设置IP和端口
        Jedis jedis = new Jedis(IP, PORT);
        // 2.保存数据
        jedis.set(key, "zhicheng");
        // 3.获取数据
        String value = jedis.get(key);
        System.out.println("redis value：" + value);
        // 4.释放资源
        jedis.close();
    }

    public static void demo02 () {
        String key = "name";
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);

        // 获取连接池
        JedisPool jedisPool = new JedisPool(config, IP, PORT);
        // 获得核心对象
        Jedis jedis = null;
        try{
            // 通过连接池获得连接
            jedis = jedisPool.getResource();
            // 设置数据
            jedis.set(key, "张三");
            // 获取数据
            String value = jedis.get(key);
            System.out.println("value : "+ value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (jedis != null) {
                jedis.close();
            }
            if (jedisPool != null) {
                jedisPool.close();
            }
        }



    }
}
