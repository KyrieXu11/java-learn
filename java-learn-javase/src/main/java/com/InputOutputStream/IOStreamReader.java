package com.InputOutputStream;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换流测试
 *
 * @author KyrieXu
 * @date 2020/2/2 10:51
 **/
public class IOStreamReader {
    /*
        字节流转换成字符流
     */
    @Test
    public void InputStreamReaderTest() throws IOException {
        FileInputStream inputStream=new FileInputStream(new File("Hello.txt"));
        InputStreamReader reader=new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        char[] ch=new char[10];
        int len;
        while((len=reader.read(ch))!=-1){
            System.out.print(new String(ch,0,len));
        }
    }
}
