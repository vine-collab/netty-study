package com.hoteach.nio;

import java.nio.ByteBuffer;

/**
 * @author hekai
 * @create 2017-10-22-10:06
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(15);
        buffer.putLong(5093289329L);
        buffer.putDouble(13.3443243);
        buffer.putChar('朕');
        buffer.putShort((short)9);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
