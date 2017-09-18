package com.hoteach.fourth.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author hekai
 * @create 2017-09-18 下午2:41
 */

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()){
                case READER_IDLE:
                    eventType = "READER_IDLE";
                    break;
                case WRITER_IDLE:
                    eventType = "WRITER_IDLE";
                    break;
                case ALL_IDLE:
                    eventType = "ALL_IDLE";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + " 超时事件：" + eventType);
            ctx.channel().close();
        }
    }

}
