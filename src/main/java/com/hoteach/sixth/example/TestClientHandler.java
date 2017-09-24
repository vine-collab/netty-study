package com.hoteach.sixth.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author hekai
 * @create 2017-09-24 下午2:33
 */

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        int randomInt = new Random().nextInt(3);

        DataInfo.MyMessage message = null;

        if (randomInt == 0) {
            message = DataInfo.MyMessage.newBuilder().setDataType(DataInfo.MyMessage.DataType.PersonType).setPerson
                    (DataInfo.Person.newBuilder().setAddress("shanghai").setAge(25).setName("hekai").build()).build();
        } else if (randomInt == 1) {
            message = DataInfo.MyMessage.newBuilder().setDataType(DataInfo.MyMessage.DataType.DogType).setDog
                    (DataInfo.Dog.newBuilder().setAge(2).setName("sam").build()).build();
        } else {
            message = DataInfo.MyMessage.newBuilder().setDataType(DataInfo.MyMessage.DataType.CatType).setCat
                    (DataInfo.Cat.newBuilder().setAge(2).setName("tom").build()).build();
        }
        ctx.channel().writeAndFlush(message);
    }
}













