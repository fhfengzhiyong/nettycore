package com.straw.im.websocket.web;


import com.alibaba.fastjson.JSONObject;
import com.straw.im.utils.SpringWebApplicationContextUtil;
import com.straw.im.websocket.core.ImQueue;
import com.straw.im.websocket.core.MessageService;
import com.straw.im.websocket.protocol.ImConstant;
import com.straw.im.websocket.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by fengzhiyong on 2017/6/29.
 */
@ServerEndpoint("/websocket")
public class WebSocket {

    @Autowired
    MessageService messageService;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {
        // Print the client message for testing purposes
        System.out.println("Received: " + message);
        System.out.println(session.getId());
        System.out.println(ImQueue.getMESSAGESize());
        Message imessage = JSONObject.parseObject(message, Message.class);
        if (messageService == null) {
            messageService = (MessageService) SpringWebApplicationContextUtil.getApplicationContext().getBean("messageServiceImpl");
        }
        if (ImConstant.C_TYPE_AUTH.equals(imessage.getType())) {
            messageService.authClientUser(imessage, session);
        }
        if (session.getUserProperties().get(ImConstant.USER_OBJECT) == null) {
            messageService.invalidRequest(session);
        }
        if (ImConstant.C_TYPE_TEXT.equals(imessage.getType())) {
            messageService.send(imessage, session);
        } else if (ImConstant.C_TYPE_ONLINE_USER.equals(imessage.getType())) {
            messageService.getOnlineUser(imessage, session);
        } else if (ImConstant.C_TYPE_MOFFLINE.equals(imessage.getType())) {
            messageService.mOffline(imessage, session);
        } else if (ImConstant.C_TYPE_NOTICY.equals(imessage.getType())) {
            messageService.send(imessage, session);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected" + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        //需要从用户列表和回话列表中清除
        System.out.println("链接关闭了++++=" + session.getId());
        messageService.destroySession(session);
    }
}
