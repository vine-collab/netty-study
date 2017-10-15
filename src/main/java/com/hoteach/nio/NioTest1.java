package com.hoteach.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author hekai
 * @create 2017-10-14-18:36
 */
public class NioTest1 {


    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < 10; i++){
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
