package com.straw.nettycore.netty;

import com.sun.javafx.scene.control.Logging;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Created by fengzy on 7/24/2017.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{
    private final ByteBuf firstMessage;
    public TimeClientHandler(){
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    //当客户端和服务端TCP链路建立成功之后，Netty的NIO 线程会调用channelactive方法，发送查询时间的指令给服务端，调用
    //ChannelHandlerContext的writeAndFlush方法方法将请求消息发送给服务端。
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }
    //当服务端返回应答消息时，channelRead 方法被调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte [] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Now is :"+body);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception from downstream");
        ctx.close();
    }
}

