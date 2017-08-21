package com.straw.nettycore.proxy.cglib;

import com.straw.nettycore.proxy.BookServer;
import com.straw.nettycore.proxy.BookServerImpl;

/**
 * Created by fengzy on 8/18/2017.
 */
public class CglibTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        BookServer bookServer = (BookServer) proxy.getInstance(new BookServerImpl());
        System.out.println(bookServer.getClass().getName());
        System.out.println(bookServer.getClass().getSuperclass().getName());
        bookServer.addBook("a", "this is aaaa");
        System.out.println(bookServer.getBook("a"));
    }
}