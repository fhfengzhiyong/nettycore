package com.straw.nettycore.c3;

/**
 * Created by fengzy on 7/19/2017.
 */
public class TimeClient {
    public static void main(String[] args) {
        new Thread(new TimeClientHandle("127.0.0.1",8080),"TimeClient-001").start();
    }
}
