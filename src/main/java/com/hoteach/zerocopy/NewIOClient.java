package com.hoteach.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author hekai
 * @create 2018-01-14-11:28
 */
public class NewIOClient {

    public static void main(String[] args) {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.connect(new InetSocketAddress("localhost", 8899));
            FileChannel channel = new FileInputStream("G:\\尚学堂_白鹤翔_架构师内部视频\\尚学堂_白鹤翔_01_并发编程\\006_并发编程基础篇_volatile关键字与atomic原子类讲解.mp4").getChannel();
            long start = System.currentTimeMillis();
            long transferCount = channel.transferTo(0, channel.size(), socketChannel);
            System.out.println("发送总字节数：" + transferCount + "耗时：" + (System.currentTimeMillis() - start));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
