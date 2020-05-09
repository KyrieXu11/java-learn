package com.InputOutputStream;

import org.junit.Test;

import java.io.*;

/**
 * @author KyrieXu
 * @date 2020/2/2 10:59
 **/
public class ObjectStreamDemo {
    /*
        对象序列化的机制允许把内存中的Java对象转换成与平台无关的二进制流，从而能够把这些对象能够永久保存在磁盘当中，或者在网络传输
     */
    @Test
    public void SerializableTest() throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("序列化测试.dat")));
        out.writeObject(new SerializableTest("小明"));
        out.flush();
        out.close();
    }

    @Test
    public void SerializableInput() throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("序列化测试.dat")));
        Object o = in.readObject();
        SerializableTest s = (SerializableTest) o;
        System.out.println(s.toString());
        in.close();
    }
}

//  一定要提供serialVersionUID才能序列化反序列化成功，否则抛出异常
class SerializableTest implements Serializable{
    private static final long serialVersionUID = -1778072912802613081L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SerializableTest(String name) {
        this.name = name;
    }

    public SerializableTest() {
    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
