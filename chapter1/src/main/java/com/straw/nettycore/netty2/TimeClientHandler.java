package com.straw.nettycore.netty2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by fengzy on 7/24/2017.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{
    private int counter;
    private byte[] req ;
    public TimeClientHandler(){
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    //当客户端和服务端TCP链路建立成功之后，Netty的NIO 线程会调用channelactive方法，发送查询时间的指令给服务端，调用
    //ChannelHandlerContext的writeAndFlush方法方法将请求消息发送给服务端。
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i = 0;i<100;i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }

    }
    //当服务端返回应答消息时，channelRead 方法被调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Now is :"+body+";the counter is:"+ ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception from downstream");
        cause.printStackTrace();
        ctx.close();
    }
}

