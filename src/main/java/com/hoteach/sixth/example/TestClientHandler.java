package com.hoteach.sixth.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hekai
 * @create 2017-09-24 下午2:33
 */

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.Person>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        DataInfo.Person person = DataInfo.Person.newBuilder().setAddress("shanghai").setAge(25).setName("hekai").build();
        ctx.channel().writeAndFlush(person);
    }
}
