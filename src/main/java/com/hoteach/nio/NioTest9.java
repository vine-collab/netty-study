package com.hoteach.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hekai
 * @create 2017-10-22-14:36
 */
public class NioTest9 {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();
            MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
            mappedByteBuffer.put(0, (byte)'a');
            mappedByteBuffer.put(3, (byte)'b');
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
