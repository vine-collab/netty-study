package com.hoteach.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hekai
 * @create 2017-12-23-16:20
 */
public class OldServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8899)) {
            while (true){
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                byte[] bytes = new byte[4096];
                while (true){
                    int read = dataInputStream.read(bytes, 0, bytes.length);
                    if (read == -1) {
                        break;
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
