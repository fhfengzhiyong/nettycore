package com.straw.nettycore.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by fengzy on 7/24/2017.
 */
public class EchoClient {
    public void connect(int port,String host){
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
