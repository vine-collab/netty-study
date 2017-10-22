package com.hoteach.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author hekai
 * @create 2017-10-22-14:48
 */
public class NioTest10 {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest", "rw")) {
            FileChannel channel = randomAccessFile.getChannel();

            FileLock lock = channel.lock(3, 5, true);
            System.out.println("valid:" + lock.isValid());
            System.out.println("lock type:" + lock.isShared());

            lock.release();

            randomAccessFile.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
