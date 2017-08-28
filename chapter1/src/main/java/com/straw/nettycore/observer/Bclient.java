package com.straw.nettycore.observer;

/**
 * Created by Administrator on 7/30/2017.
 */
public class Bclient implements Client {
    public void sendMessage(String s) {
        System.out.println("im b i receive message:  " +s);
    }
}
