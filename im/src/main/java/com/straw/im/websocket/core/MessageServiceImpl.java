package com.straw.im.websocket.core;


import com.alibaba.fastjson.JSONObject;
import com.straw.im.utils.cache.ECache;
import com.straw.im.utils.cache.NapCache;
import com.straw.im.websocket.protocol.ImConstant;
import com.straw.im.websocket.protocol.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service
public class MessageServiceImpl implements MessageService {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void send(Message message, WebSocketSession session) {
        AdminUser ex = (AdminUser) session.getAttributes().get(ImConstant.USER_OBJECT);
        if (ex != null) {
            message.setFrom_user_nick(ex.getNickName());
        }
        message.setMessage_date(simpleDateFormat.format(new Date()));
        ImQueue.offerMessage(message);
    }

    @Override
    public boolean authClientUser(Message imessage, WebSocketSession session) {
        //检查连接可用性，及时删除一些过期的终端
        ImQueue.checkIsOpen();
        AdminUser adminUser = null;
        String fromUser = imessage.getFrom_user();
        if (StringUtils.isEmpty(fromUser) || "null".equals(fromUser)) {
            fromUser = UUID.randomUUID().toString();
            adminUser = new AdminUser();
            adminUser.setId(fromUser);
            adminUser.setNickName("游客" + fromUser.substring(0, 5));
            NapCache.Instance().putValue(adminUser.getId(), adminUser);
        } else {
            adminUser = NapCache.Instance().getValue(fromUser);
        }
        //查询是否该用户的账号已经存在一个终端，从而确定是否需要再次通知增加用户
        // ArrayList user = ImQueue.getUser(session, fromUser);

        //校验是否需要退出现有用户
        AdminUser ex = (AdminUser) session.getAttributes().get(ImConstant.USER_OBJECT);
        if (ex != null) {
            System.out.println("se");
            destroySession(session);
        }
        if (adminUser != null) {
            session.getAttributes().put(ImConstant.USER_OBJECT, adminUser);
            ImQueue.addUser(fromUser, session.getId());
            ImQueue.addClient(session.getId(), session);
            //通知新用户上线
            //if (user ==null){
            Message message = new Message();
            message.setFrom_user(ImConstant.S_USER_SYSTEM);
            message.setType(ImConstant.S_TYPE_USER_LOGIN);
            message.setMessage_context(JSONObject.toJSONString(adminUser));
            send(message, session);
            //}
            return true;
        }
        return false;
    }

    @Override
    public void getOnlineUser(Message imessage, WebSocketSession session) {
        List<WebSocketSession> clientSession = ImQueue.getClientSession();
        if (clientSession != null && clientSession.size() > 0) {
            List<AdminUser> adminUsers = ImQueue.getOnlineUser();
            try {
                Message message = new Message();
                message.setFrom_user(ImConstant.S_USER_SYSTEM);
                message.setType(ImConstant.S_TYPE_USER_LIST);
                message.setMessage_context(JSONObject.toJSONString(adminUsers));
                WebSocketMessage webSocketMessage = new TextMessage(JSONObject.toJSONString(message));
                session.sendMessage(webSocketMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroySession(WebSocketSession session) {
        boolean b = ImQueue.removeClient(session.getId());
        //通知所有终端用户已下线
        if (b) {
            Message message = new Message();
            AdminUser adminUser = (AdminUser) session.getAttributes().get(ImConstant.USER_OBJECT);
            //当该用户在没有在线的终端时通知所有用户，该用户已下线
            if (adminUser != null) {
                message.setMessage_context(adminUser.getId());
                message.setMessage_date(simpleDateFormat.format(new Date()));
                message.setFrom_user(ImConstant.S_USER_SYSTEM);
                message.setType(ImConstant.S_TYPE_USER_LOGOUT);
                ImQueue.offerMessage(message);
            }
        }

    }

    @Override
    public void invalidRequest(WebSocketSession session) {
        Message message = new Message();
        message.setFrom_user(ImConstant.S_USER_SYSTEM);
        message.setType(ImConstant.S_TYPE_INVALID);
        message.setMessage_context("无效请求");
        try {
            WebSocketMessage webSocketMessage = new TextMessage(JSONObject.toJSONString(message));
            session.sendMessage(webSocketMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mOffline(Message imessage, WebSocketSession session) {
        imessage.setFrom_user(ImConstant.S_USER_SYSTEM);
        imessage.setType(ImConstant.S_TYPE_M_USER_LOGOUT);
        send(imessage, session);
    }
}