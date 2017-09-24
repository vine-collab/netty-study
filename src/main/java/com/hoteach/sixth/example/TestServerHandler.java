package com.hoteach.sixth.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hekai
 * @create 2017-09-24 下午2:24
 */

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.Person>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) throws Exception {
        System.out.println(msg.getName());
    }
}
