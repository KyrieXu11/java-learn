package com.Test;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author KyrieXu
 * @since 2020/3/5 20:26
 **/
public class SocketTest {

    @Test
    public void test01() throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        SocketChannel socketChannel = socket.getChannel();
        // 分配1024个字节
        ByteBuffer buffer=ByteBuffer.wrap("我叼你妈的".getBytes());
        socketChannel.write(buffer);
    }


    @Test
    public void test02() throws IOException {
        ServerSocketChannel socketChannel=ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(999));
        SocketChannel socket = socketChannel.accept();
    }

    @Test
    public void  client() throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        BufferedOutputStream out=new BufferedOutputStream(socket.getOutputStream());
        out.write("wdnmd".getBytes());
        out.flush();
        out.close();
    }


    @Test
    public void server() throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
        String s=new String(in.readAllBytes());
        System.out.println(s);
        in.close();
    }

    // 通过套接字发送图片
    @Test
    @SneakyThrows
    public void picClient(){
        Socket socket = new Socket("127.0.0.1",9999);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("美女2.jpg")));
        byte[] bytes= new byte[1024];
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        int len;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        out.close();
        in.close();
    }

    // 通过套接字接收图片，并且保存在本地
    @Test
    @SneakyThrows
    public void picServer(){
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = ss.accept();
        BufferedInputStream in =new BufferedInputStream(socket.getInputStream());
        byte[] bytes=new byte[1024];
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("美女3.jpg")));
        int len;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        out.close();
        in.close();
    }

    @Test
    @SneakyThrows
    public void picRespClient(){
        Socket socket = new Socket("127.0.0.1",9999);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("美女2.jpg")));
        byte[] bytes= new byte[1024];
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        int len;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        // 不能关闭out，会抛出异常
        //out.close();
        socket.shutdownOutput();
        BufferedInputStream in2 = new BufferedInputStream(socket.getInputStream());
        InputStreamReader message = new InputStreamReader(in2);
        char[] ch=new char[5];
        // This method will block until some input
        // is available, an I/O error occurs, or the end of the stream is reached.
        // read是一个阻塞方法，要让socket关闭输出才能接收
        while ((len = message.read(ch)) != -1) {
            System.out.println(new String(ch,0,len));
        }
        in2.close();
        message.close();
        in.close();

    }

    @Test
    @SneakyThrows
    public void picRespServer(){
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = ss.accept();
        BufferedInputStream in =new BufferedInputStream(socket.getInputStream());
        byte[] bytes=new byte[1024];
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("美女3.jpg")));
        int len;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        System.out.println("传输完成");
        BufferedOutputStream out2=new BufferedOutputStream(socket.getOutputStream());
        OutputStreamWriter writer=new OutputStreamWriter(out2);
        writer.write("你好挖");
        writer.flush();

        out2.close();
        writer.close();
        out.close();
        in.close();
    }
}
