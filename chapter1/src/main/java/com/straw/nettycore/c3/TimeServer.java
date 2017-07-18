package com.straw.nettycore.c3;

/**
 * Created by fengzy on 7/18/2017.
 */
public class TimeServer {
    public static void main(String[] args) {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8080);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
