package com.straw.nettycore.proxy.jdkproxy;

import com.straw.nettycore.proxy.BookServer;
import com.straw.nettycore.proxy.BookServerImpl;

/**
 * Created by fengzy on 8/18/2017.
 */
public class MainTest {
    public static void main(String[] args) {
        BookServer s = new BookServerImpl();

        InvoProxy proxy = new InvoProxy();
        BookServer bookServer = (BookServer) proxy.bind(new BookServerImpl());
        bookServer.addBook("a", "this is a");
        System.out.println(bookServer.getBook("a"));
    }
}
