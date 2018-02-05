package com.straw.im.websocket.core;


import com.alibaba.fastjson.JSONObject;
import com.straw.im.utils.cache.ECache;
import com.straw.im.websocket.protocol.ImConstant;
import com.straw.im.websocket.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service
public class MessageServiceImpl implements MessageService {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void send(Message message, Session session) {
        AdminUser ex = (AdminUser) session.getUserProperties().get(ImConstant.USER_OBJECT);
        if (ex != null) {
            message.setFrom_user_nick(ex.getNickName());
        }
        message.setMessage_date(simpleDateFormat.format(new Date()));
        ImQueue.offerMessage(message);
    }

    @Override
    public boolean authClientUser(Message imessage, Session session) {
        //检查连接可用性，及时删除一些过期的终端
        ImQueue.checkIsOpen();
        //查询是否该用户的账号已经存在一个终端，从而确定是否需要再次通知增加用户
        ArrayList user = ImQueue.getUser(session, imessage.getFrom_user());
        AdminUser adminUser = (AdminUser) ECache.getCache().get(imessage.getFrom_user()).getObjectValue();

        //校验是否需要退出现有用户
        AdminUser ex = (AdminUser) session.getUserProperties().get(ImConstant.USER_OBJECT);
        if (ex != null) {
            destroySession(session);
        }
        if (adminUser != null) {
            session.getUserProperties().put(ImConstant.USER_OBJECT, adminUser);
            ImQueue.addUser(imessage.getFrom_user(), session.getId());
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
    public void getOnlineUser(Message imessage, Session session) {
        List<Session> clientSession = ImQueue.getClientSession();
        if (clientSession != null && clientSession.size() > 0) {
            List<AdminUser> adminUsers = ImQueue.getOnlineUser();
            try {
                Message message = new Message();
                message.setFrom_user(ImConstant.S_USER_SYSTEM);
                message.setType(ImConstant.S_TYPE_USER_LIST);
                message.setMessage_context(JSONObject.toJSONString(adminUsers));
                session.getBasicRemote().sendText(JSONObject.toJSONString(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroySession(Session session) {
        boolean b = ImQueue.removeClient(session.getId());
        //通知所有终端用户已下线
        if (b) {
            Message message = new Message();
            AdminUser adminUser = (AdminUser) session.getUserProperties().get(ImConstant.USER_OBJECT);
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
    public void invalidRequest(Session session) {
        Message message = new Message();
        message.setFrom_user(ImConstant.S_USER_SYSTEM);
        message.setType(ImConstant.S_TYPE_INVALID);
        message.setMessage_context("无效请求");
        try {
            session.getBasicRemote().sendText(JSONObject.toJSONString(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mOffline(Message imessage, Session session) {
        imessage.setFrom_user(ImConstant.S_USER_SYSTEM);
        imessage.setType(ImConstant.S_TYPE_M_USER_LOGOUT);
        send(imessage, session);
    }
}