package com.InputOutputStream;

import org.junit.Test;

import java.io.*;

/**
 * @author KyrieXu
 * @date 2020/2/1 11:05
 **/
public class BufferedTest {
    /**
     * 处理流测试，加快处理流传输速度
     * 读文本文件
     */
    @Test
    public void BufferedStreamTest(){
        File file=new File("Hello.txt");
        BufferedReader reader=null;
        StringBuilder str= new StringBuilder();
        String temp;
        try {
            reader=new BufferedReader(new FileReader(file));
//            读取文本文件一行的字符串
            while ((temp=reader.readLine())!=null){
                str.append(temp).append('\n');
            }
            System.out.println(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
//                    在关闭外层流的同时也会关闭内层的流
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
