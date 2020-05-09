package com.InputOutputStream;

import org.junit.Test;

import java.io.*;

/**
 * 1. 流的分类：
 *  1. 操作数据单位： 字节流，字符流
 *  2. 数据的流向： 输入流，输出流
 *  3. 流的角色： 处理流(在节点流的外层包裹的一层流就是处理流，让流的传输快速一点)，节点流
 * 2. 流的体系结构
 *  抽象基类         节点流(或文件流)          缓冲流(处理流)
 *  字节流
 *  InputStream     FileInputStream         BufferedInputStream
 *  OutputStream    FileOutputStream        BufferedOutputStream
 *  字符流
 *  Reader          FileReader              BufferedReader
 *  Writer          FileWriter              BufferedWriter
 * @author KyrieXu
 * @date 2020/1/31 11:17
 **/
public class FileReaderWriterDemo {

    @Test
    public void TestFileReader(){
//        main方法是相较于当前工程，而单元测试是相较于当前的模块(module)
//        1. 实例化File对象
        File file=new File("Hello.txt");
//        2. 提供具体的流
        try {
            FileReader reader=new FileReader(file);
//            3. 数据的读入,返回读入的一个字符，如果达到文件末尾，返回-1
            int data = reader.read();
            while (data!=-1){
                System.out.print(((char) data));
                data = reader.read();
            }
//            4. 关闭流
            reader.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFileReader02(){
        File file=new File("Hello.txt");
        FileReader stream=null;
        char[] c=new char[5];
        try {
            stream=new FileReader(file);
            int len;
            while ((len=stream.read(c))!=-1){
//                这里的循环上界只能是读取的长度，不能是字符数组的长度，否则可能造成这次的读取还保留上次读取结果的勾过导致出错
//                for (int i = 0; i < len; i++) {
//                    System.out.print(c[i]);
//                }
//                也可以使用这种方式，即每次从0开始取，取len个字符
                System.out.print(new String(c,0,len));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(stream!=null) {
                try {
                    stream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void TestFileWriter(){
        /*
            1. 在写入的时候，文件可以不存在，此时系统自动创建一个文件，此时的文件编码是UTF-8格式的
            2. 调用Write方法的时候，是覆盖之前写的内容的，FileWriter()的第二个参数如果是 false 表示覆盖原文件，如果是true则表示在
                原来的文件内容的基础上继续写内容，默认是false
         */
        File file=new File("Write.md");

        FileWriter writer;

        try {
            writer=new FileWriter(file,true);
            System.out.println(writer.getEncoding());   // UTF-8
            writer.write("写入测试");
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
