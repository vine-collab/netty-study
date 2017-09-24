package com.hoteach.sixth.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author hekai
 * @create 2017-09-24 下午2:24
 */

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {
        DataInfo.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == DataInfo.MyMessage.DataType.PersonType) {
            DataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
        } else if (dataType == DataInfo.MyMessage.DataType.DogType) {
            DataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else {
            DataInfo.Cat dog = msg.getCat();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        }
    }
}
