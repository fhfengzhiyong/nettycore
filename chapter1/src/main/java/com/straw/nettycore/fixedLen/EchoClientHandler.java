package com.straw.nettycore.fixedLen;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by fengzy on 7/25/2017.
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
    private int counter;
    static final String ECHO_ERQ = "Hi,straw .Welcome to Netty";
    public EchoClientHandler() {
    }

    //链接成功
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i = 0;i<10;i++){
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_ERQ.getBytes()));
        }
        System.out.println("发送成功");
    }
    //当读到新数据时
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("message: "+msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
