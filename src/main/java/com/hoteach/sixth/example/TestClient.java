package com.hoteach.sixth.example;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

/**
 * @author hekai
 * @create 2017-09-24 下午2:30
 */

public class TestClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyClientInitializer());
            ChannelFuture future = bootstrap.connect("localhost", 8899).sync();
            future.channel().closeFuture().sync();

        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
