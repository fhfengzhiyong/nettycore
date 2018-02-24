package com.straw.nettycore.test.cli2netty.to;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author fengzy
 * @date 2/24/2018
 */
public class HttpServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());
            Map<String, List<String>> parameters = queryStringDecoder.parameters();
            Iterator<String> iterator = parameters.keySet().iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                List<String> v = parameters.get(next);
                System.out.println(next + ":" + v.get(0));
            }
            String name = "";
            if (parameters.get("name") != null) {
                name = parameters.get("name").get(0);
            }
            System.out.println("参数为name: " + name);
            //响应对象
            String response = "<html><body>hello " + name + "</body></html>";
            byte[] bytes = response.getBytes("utf-8");
            FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(bytes));
            httpResponse.headers().set("Content-Type", "text/html; charset=utf-8");
            httpResponse.headers().set("Content-Length", Integer.toString(bytes.length));
            httpResponse.headers().set("status", "gzip");
            ctx.writeAndFlush(httpResponse);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
    }
}