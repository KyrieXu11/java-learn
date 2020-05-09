package com.InputOutputStream;

import org.junit.Test;

import java.io.*;

/**
 * 1. 文本文件使用字符流(FileReader、FileWriter)
 *
 * @author KyrieXu
 * @date 2020/2/1 10:47
 **/
public class FileIOStreamDemo {
    /**
     * 用字节流读文本文件
     */
    @Test
    public void TestFileInputStream01() {
        File file = new File("Write.md");
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
//            如果使用的字节数组过小的话会导致汉字读出来是乱码的情况
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                System.out.print(new String(b, 0, len));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null)
                    in.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用字节流读图片，复制图片
     */
    @Test
    public void TestFileInputStream02() {
        File file = new File("美女.jpg");
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(new File("美女2.jpg"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in!=null){
                try {
                    in.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
