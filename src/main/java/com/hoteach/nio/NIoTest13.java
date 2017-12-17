package com.hoteach.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author hekai
 * @create 2017-11-26-22:03
 */
public class NIoTest13 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile inputFile = new RandomAccessFile("NioTest13_In.txt", "r");
        RandomAccessFile outputfile = new RandomAccessFile("NioTest13_Out.txt", "rw");

        long length = new File("NioTest13_In.txt").length();
        FileChannel inputFileChannel = inputFile.getChannel();
        FileChannel outputfileChannel = outputfile.getChannel();

        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);

        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);
        ByteBuffer outputData = encoder.encode(charBuffer);
        outputfileChannel.write(outputData);

        inputFile.close();
        outputfile.close();




    }
}





















