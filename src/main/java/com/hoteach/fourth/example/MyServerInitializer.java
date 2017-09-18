package com.hoteach.fourth.example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;


/**
 * @author hekai
 * @create 2017-09-18 下午2:30
 */

public class MyServerInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(5, 7, 10, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
