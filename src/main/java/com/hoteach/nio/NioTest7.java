package com.hoteach.nio;

import java.nio.ByteBuffer;

/**
 * 只读buffer,可以将普通buffer转换成readonlybuffer，反之不然。
 * @author hekai
 * @create 2017-10-22-10:41
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readOnlyBuffer.getClass());

        readOnlyBuffer.position();
    }
}
