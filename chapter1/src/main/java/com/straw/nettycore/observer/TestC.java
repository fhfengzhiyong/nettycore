package com.straw.nettycore.observer;

/**
 * Created by Administrator on 7/30/2017.
 */
public class TestC {
    public static void main(String[] args) {
        //建立主题
        MessageSubject messageSubject = new MessageSubject();
        //建立客户端
        Client a = new Aclient();
        messageSubject.register(a);

        messageSubject.notification(" 你好，");


        Client b = new Bclient();
        messageSubject.register(b);


        messageSubject.notification(" 再次说你好，");

        messageSubject.remove(b);


        messageSubject.notification(" 最后一次说你好，");
    }
}
