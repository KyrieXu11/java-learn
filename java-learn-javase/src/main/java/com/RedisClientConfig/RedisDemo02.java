package com.RedisClientConfig;

import lombok.SneakyThrows;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author KyrieXu
 * @date 2020/2/15 17:06
 **/
public class RedisDemo02 {
    @Test
    public void JedisPoolTest(){
        Jedis jedis = JedisUtils.getJedis();
        System.out.println(jedis.ping());
        System.out.println(jedis.get("jedis:key"));
        Map<String, String> map = jedis.hgetAll("hashkey");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        JedisUtils.closeJedis(jedis);
    }


}


class JedisUtils {
    private static JedisPool jedisPool;
    private static String auth;

    static {
        InputStream stream = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        assert stream != null;
        BufferedInputStream in = new BufferedInputStream(stream);
        Properties properties = new Properties();
        try {
            properties.load(in);
            String host = properties.getProperty("jedis.host");
            int port = Integer.parseInt(properties.getProperty("jedis.port"));
            auth = properties.getProperty("jedis.auth");
            JedisPoolConfig config=new JedisPoolConfig();
//            最大连接数
            config.setMaxTotal(5);
//            最大空闲数
            config.setMaxIdle(1);
            jedisPool = new JedisPool(config,host,port);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        jedis.auth(auth);
        return jedis;
    }

    public static void closeJedis(Jedis jedis){
        if(null!=jedis){
            jedis.close();
        }
        if(null!=jedisPool){
            jedisPool.close();
        }
    }
}
