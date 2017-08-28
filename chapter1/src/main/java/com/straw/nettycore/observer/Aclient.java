package com.straw.nettycore.observer;

/**
 * Created by Administrator on 7/30/2017.
 */
public class Aclient implements Client {
    public void sendMessage(String s) {
        System.out.println("im a i receive message:  " +s);
    }
}
