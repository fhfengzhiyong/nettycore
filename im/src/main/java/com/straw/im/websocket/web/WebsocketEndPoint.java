package com.straw.im.websocket.web;

import com.alibaba.fastjson.JSONObject;
import com.straw.im.utils.SpringWebApplicationContextUtil;
import com.straw.im.websocket.core.ImQueue;
import com.straw.im.websocket.core.MessageService;
import com.straw.im.websocket.protocol.ImConstant;
import com.straw.im.websocket.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * @author fengzy
 * @date 2/7/2018
 */
public class WebsocketEndPoint extends TextWebSocketHandler {

    @Autowired
    MessageService messageService;

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) {
        Message imessage = null;
        try {
            //super.handleTextMessage(session, message);
            System.out.println(session.getId());
            System.out.println(message.getPayload());
            System.out.println(ImQueue.getMESSAGESize());
            imessage = JSONObject.parseObject(message.getPayload(), Message.class);
            if (messageService == null) {
                messageService = (MessageService) SpringWebApplicationContextUtil.getApplicationContext().getBean("messageService");
            }
            if (ImConstant.C_TYPE_AUTH.equals(imessage.getType())) {
                messageService.authClientUser(imessage, session);
            }
            if (session.getAttributes().get(ImConstant.USER_OBJECT) == null) {
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
        } catch (Exception e) {
            e.printStackTrace();
            imessage = new Message();
            imessage.setMessage_context("服务器错误哎呀");
            WebSocketMessage webSocketMessage = new TextMessage(JSONObject.toJSONString(imessage));
            try {
                session.sendMessage(webSocketMessage);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Client connected" + session.getId());

    }

    /**
     * 关闭连接时触发
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("链接关闭了++++=" + session.getId());
        messageService.destroySession(session);
    }
}