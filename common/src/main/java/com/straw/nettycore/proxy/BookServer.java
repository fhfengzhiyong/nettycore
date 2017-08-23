package com.straw.nettycore.proxy;

/**
 * Created by fengzy on 8/18/2017.
 */
public interface BookServer {
    /**
     * 添加一本图书
     *
     * @param bookName 书名
     * @param content  内容
     */
    void addBook(String bookName, String content);

    /**
     * 根据内容取图书返回内容
     *
     * @param bookName
     * @return content   图书内容
     */
    String getBook(String bookName);
}
