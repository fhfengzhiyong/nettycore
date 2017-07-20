package com.straw.nettycore.aio;

/**
 * Created by fengzy on 7/19/2017.
 */
public class TimeServer {
    public static void main(String[] args) {
        new Thread(new AsyncTimeServerHandler(8080),"AIO-001").start();
    }
}
