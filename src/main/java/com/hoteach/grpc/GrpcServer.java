package com.hoteach.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author hekai
 * @create 2017-10-06-20:26
 */
public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();
        System.out.println("server started!");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭jvm");
            GrpcServer.this.stop();
        }));

        System.out.println("关闭jvm之后");
    }

    private void stop(){
        if(this.server != null){
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if(this.server != null){
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}
