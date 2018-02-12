package com.straw.im.websocket.core;


import com.straw.im.websocket.protocol.ImConstant;
import com.straw.im.websocket.protocol.Message;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by fengzhiyong on 2017/6/29.
 */
public class ImQueue {
    //消息列表
    private static final LinkedBlockingQueue<Message> MESSAGE = new LinkedBlockingQueue<Message>(200000) {
    };
    //终端列表
    private static final Map<String, WebSocketSession> CLIENT_LIST = new ConcurrentHashMap<String, WebSocketSession>();
    //用户列表（存放用户和终端关系）
    private static final Map<String, ArrayList<String>> USER_LIST = new ConcurrentHashMap<String, ArrayList<String>>();

    //存储消息
    public static boolean offerMessage(Message message) {
        MESSAGE.offer(message);
        return true;
    }

    //增加终端连接
    public static void addClient(String sessonId, WebSocketSession session) {
        CLIENT_LIST.put(sessonId, session);
    }

    //获取终端列表
    public static List<WebSocketSession> getClientSession() {
        Iterator<Map.Entry<String, WebSocketSession>> iterator = CLIENT_LIST.entrySet().iterator();
        List<WebSocketSession> list = new ArrayList<WebSocketSession>();
        while (iterator.hasNext()) {
            list.add(iterator.next().getValue());
        }
        return list;
    }

    public static List<AdminUser> getOnlineUser() {
        List<AdminUser> userList = new ArrayList<AdminUser>();
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = USER_LIST.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> next = iterator.next();
            ArrayList<String> value = next.getValue();
            WebSocketSession session = CLIENT_LIST.get(value.get(0));
            Object adminUser = session.getAttributes().get(ImConstant.USER_OBJECT);
            if (adminUser != null) {
                userList.add((AdminUser) adminUser);
            }
        }
        return userList;
    }

    //增加用户到列表中
    public static synchronized boolean addUser(String userId, String sessionId) {
        ArrayList<String> strings = USER_LIST.get(userId);
        if (strings == null) {
            strings = new ArrayList<String>();
        } else {
            if (strings.contains(sessionId)) {
                return false;
            }
        }
        strings.add(sessionId);
        USER_LIST.put(userId, strings);
        return true;
    }

    //删除用户
    private synchronized static boolean removeUser(String sessionId) {
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = USER_LIST.entrySet().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> next = iterator.next();
            ArrayList<String> value = next.getValue();
            boolean remove = value.remove(sessionId);
            if (remove) {
                if (value.size() == 0) {
                    USER_LIST.remove(next.getKey());
                    b = true;
                }
                break;
            }
        }
        return b;
    }

    //获取用户对应的终端
    public static ArrayList<String> getUser(WebSocketSession session, String userId) {
        //判断这些终端是否已经关闭
        return USER_LIST.get(userId);
    }

    /**
     * 消费消息
     *
     * @return
     */
    public static Message consumeMessage() throws InterruptedException {
        return MESSAGE.take();
    }

    public static boolean removeClient(String id) {
        CLIENT_LIST.remove(id);
        return removeUser(id);
    }

    public static int getMESSAGESize() {
        return MESSAGE.size();
    }

    public static void checkIsOpen() {
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = USER_LIST.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> next = iterator.next();
            ArrayList<String> value = next.getValue();
            if (value != null) {
                for (String li : value) {
                    WebSocketSession session = CLIENT_LIST.get(li);
                    if (!session.isOpen()) {
                        removeClient(session.getId());
                    }
                }
            }
        }
    }
}
