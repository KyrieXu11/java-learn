package com.InputOutputStream;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Objects;

/**
 * @author KyrieXu
 * @date 2020/1/30 12:45
 **/
public class FileDemo01 {
    /*
        File 类对象即可以表示一个文件，也可以表示一个文件夹
     */
    @Test
    public void FileDemo() {
        //File file=new File("Hello.txt");
        //System.out.println(file.length());
        try {
            //FileInputStream stream=new FileInputStream(file);
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("Hello.txt");
            byte[] bytes = new byte[1024];
            BufferedInputStream inputStream = new BufferedInputStream(Objects.requireNonNull(stream));
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
            inputStream.close();
            URL url = Objects.requireNonNull(this.getClass().getClassLoader().getResource("Hello.txt"));
            File file = new File(url.getFile());
            FileReader reader = new FileReader(file);
            char[] ch = new char[5];
            while ((len = reader.read(ch)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(ch[i]);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
