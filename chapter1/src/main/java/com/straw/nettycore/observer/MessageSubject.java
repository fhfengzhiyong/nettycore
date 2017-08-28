package com.straw.nettycore.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 7/30/2017.
 *
 * 这里一个消息主题
 *
 */
public class MessageSubject implements Subject {

    private List<Client> clients;

    public MessageSubject() {
        this.clients = new ArrayList<Client>();
    }

    public boolean register(Client client) {
        return clients.add(client);
    }

    public boolean remove(Client client) {
        return clients.remove(client);
    }

    public void notification(String s) {
        for (Client c:clients){
            c.sendMessage(s);
        }
    }
}
