package com.straw.nettycore.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by fengzy on 7/19/2017.
 */
public class AsyncTimeServerHandler  implements Runnable {
    private int port;
    CountDownLatch latch;//占用数
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            //创建异步服务端通道
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server si start in port :"+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
            latch = new CountDownLatch(1);
            doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doAccept() {
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
