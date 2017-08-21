package com.straw.nettycore.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengzy on 8/18/2017.
 * 图书管理的实际类
 */
public class BookServerImpl implements BookServer {

    Map<String, String> books = new HashMap<String, String>();

    @Override
    public void addBook(String bookName, String content) {
        books.put(bookName, content);
    }

    @Override
    public String getBook(String bookName) {
        return books.get(bookName);
    }
}
