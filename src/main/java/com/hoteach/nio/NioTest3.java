package com.hoteach.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hekai
 * @create 2017-10-15-13:23
 */
public class NioTest3 {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("NioTest")) {
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            byte[] bytes = "hello world".getBytes();
            for(int i = 0; i < bytes.length; i++){
                byteBuffer.put(bytes[i]);
            }

            byteBuffer.flip();
            channel.write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
