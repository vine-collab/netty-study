package com.hoteach.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hekai
 * @create 2017-10-15-13:09
 */
public class NioTest2 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("NioTest")) {
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            channel.read(byteBuffer);
            byteBuffer.flip();

            while (byteBuffer.remaining() > 0) {
                byte b = byteBuffer.get();
                System.out.println("Character:" + (char) b);
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
