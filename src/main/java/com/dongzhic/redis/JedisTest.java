package com.dongzhic.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author dongzc
 * @date 2018/8/12 16:02
 */
public class JedisTest {

    private final String IP = "58.87.120.249";
    private final int PORT = 6379;

    @Test
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

    @Test
    public void demo02 () {
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
