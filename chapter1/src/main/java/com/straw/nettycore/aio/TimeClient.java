package com.straw.nettycore.aio;

/**
 * Created by fengzy on 7/19/2017.
 */
public class TimeClient {
    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandler("127.0.0.1",8080)).start();
    }
}