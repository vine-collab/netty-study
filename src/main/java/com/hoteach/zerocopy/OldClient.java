package com.hoteach.zerocopy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author hekai
 * @create 2017-12-23-16:51
 */
public class OldClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8899);
        FileInputStream inputStream = new FileInputStream("G:\\尚学堂_白鹤翔_架构师内部视频\\尚学堂_白鹤翔_01_并发编程\\006_并发编程基础篇_volatile关键字与atomic原子类讲解.mp4");
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];
        long readCount;
        long total = 0;
        long start = System.currentTimeMillis();
        while((readCount = inputStream.read(bytes)) >= 0){
            total += readCount;
            dataOutputStream.write(bytes);
        }
        System.out.println("发送总字节数：" + total + ",耗时:" + (System.currentTimeMillis() - start));
        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}




































