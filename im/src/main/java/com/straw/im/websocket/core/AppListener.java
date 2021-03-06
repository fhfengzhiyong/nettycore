package com.straw.im.websocket.core;


import com.alibaba.fastjson.JSONObject;
import com.straw.im.websocket.protocol.ImConstant;
import com.straw.im.websocket.protocol.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.util.List;

/**
 * Created by fengzhiyong on 2017/6/29.
 */
public class AppListener implements ServletContextListener {
    private MessageSendThread myThread;

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        if (myThread != null && myThread.isInterrupted()) {
            myThread.interrupt();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent e) {
        String str = null;
        if (str == null && myThread == null) {
            myThread = new MessageSendThread();
            myThread.start(); // servlet 上下文初始化时启动 socket
        }
    }
}

/**
 * 自定义一个 Class 线程类继承自线程类，重写 run() 方法，用于从后台获取并处理数据
 *
 * @author Champion.Wong
 */
class MessageSendThread extends Thread {
    private MessageSendThread myThread;

    @Override
    public void run() {
        while (true) {// 线程未中断执行循环
            try {
                Message message = ImQueue.consumeMessage();
                System.out.println("==========================================================================");
                List<WebSocketSession> clientSession = ImQueue.getClientSession();
                for (WebSocketSession session : clientSession) {
                    if (session.isOpen()) {
                        //全部用户
                        if (StringUtils.isEmpty(message.getTo_user())) {
                            WebSocketMessage webSocketMessage = new TextMessage(JSONObject.toJSONString(message));
                            session.sendMessage(webSocketMessage);
                        } else {
                            String uid = ((AdminUser) session.getAttributes().get(ImConstant.USER_OBJECT)).getId();
                            if (message.getTo_user().contains(uid) || message.getFrom_user().equals(uid)) {
                                message.setFrom_user_nick(message.getFrom_user_nick() + "(私)");
                                WebSocketMessage webSocketMessage = new TextMessage(JSONObject.toJSONString(message));
                                session.sendMessage(webSocketMessage);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("线程中断...............................................................");
                e.printStackTrace();
                myThread = new MessageSendThread();
                myThread.start(); //
            }
        }
    }
}
