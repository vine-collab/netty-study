package com.hoteach.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author hekai
 * @create 2017-11-05-11:37
 */
public class NioServer {

    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(item -> {
                final SocketChannel client;
                try {
                    if (item.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) item.channel();
                        client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                        String key = UUID.randomUUID().toString();
                        clientMap.put(key, client);
                    } else if(item.isReadable()){
                       client =  (SocketChannel)item.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int count = client.read(readBuffer);
                        if(count > 0){
                            readBuffer.flip();
                            Charset charset = Charset.forName("utf-8");
                            String receivedMessage = String.valueOf(charset.decode(readBuffer).array());
                            System.out.println(client + ":" + receivedMessage);


                        }
                        
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

































