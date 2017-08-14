package com.straw.nettycore.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by fengzy on 8/14/2017.
 */
public class WebSocketServer {
    public void run() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup worderGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, worderGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("http-codec", new HttpServerCodec());
                            pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
                            pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                            pipeline.addLast("handler", new WebSocketServerHandler());
                        }
                    });
            Channel ch = b.bind(8080).sync().channel();
            System.out.println("Web socket server started at post 8080.");
            System.out.println("open your browser and navigate to http://localhost:8080/");

        } finally {
            bossGroup.shutdownGracefully();
            worderGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new WebSocketServer().run();
    }
}



















































