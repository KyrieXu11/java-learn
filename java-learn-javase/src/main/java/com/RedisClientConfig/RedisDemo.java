package com.RedisClientConfig;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.SneakyThrows;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author KyrieXu
 * @date 2020/2/15 15:54
 **/
public class RedisDemo {
    @SneakyThrows
    @Test
    public void JedisTest01() {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("jedis.properties");
        assert stream != null;
//        处理流，加快文件读写速度
        BufferedInputStream in = new BufferedInputStream(stream);
        Properties properties = new Properties();
        properties.load(in);
        String host = properties.getProperty("jedis.host");
        String portStr = properties.getProperty("jedis.port");
        int port = Integer.parseInt(portStr);
//        1. 获取连接
        Jedis jedis=new Jedis(host,port);
//        2. 设置密码，如果redis不设置密码的话，不能连接redis
        jedis.auth("123");
//        3. 检测是否连接成功，如果连接成功则继续
        String res = jedis.ping();
        if("PONG".equals(res)){
            jedis.setnx("jedis:key","jedis:value");
            jedis.close();
        }
    }
}
