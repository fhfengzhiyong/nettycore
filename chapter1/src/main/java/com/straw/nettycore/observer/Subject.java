package com.straw.nettycore.observer;

/**
 * Created by fengzy on 7/30/2017.
 * 主题接口
 * 这里我们要实现一个订阅和通知功能的程序，客户端可以自由的订阅和退订，
 * 这里说的让客户端可以随时都能增加或者减少，可以理解为在使用我们设计的这个订阅通知模式时。
 */
public interface Subject {
    public boolean register(Client client);
    public boolean remove(Client client);
    public void notification(String mes);
}
