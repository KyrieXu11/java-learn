package com.RedisClientConfig;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SSHService {
    static Integer lport;//本地端口
    static String rhost;//远程数据库服务器
    static int rport;//远程数据库服务端口

    static String user;//SSH连接用户名
    static String password;//SSH连接密码
    static String host;//SSH服务器
    static int port;//SSH访问端口

    static {
        //读取配置文件
        try {
            // 获取hive.properties文件的路径
            InputStream is = SSHService.class.getClassLoader().getResourceAsStream("SSH.properties");
            Properties prop = new Properties();
            prop.load(is);
            // 读取配置文件的值
            lport = Integer.valueOf(prop.getProperty("lport"));
            rhost = prop.getProperty("rhost");
            rport = Integer.parseInt(prop.getProperty("rport"));
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            host = prop.getProperty("host");
            port = Integer.parseInt(prop.getProperty("port"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sshRun() {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            // step1：建立ssh连接
            session.connect();
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
            //step2： 设置SSH本地端口转发，本地转发到远程
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);
//            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
            Jedis jedis=new Jedis(rhost,rport);
            System.out.println(jedis.ping());
        } catch (Exception e) {
            if (null != session) {
                //关闭ssh连接
                session.disconnect();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sshRun();
    }

}