package com.straw.im.websocket.core;

import com.straw.im.websocket.protocol.Message;

import javax.websocket.Session;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface MessageService {
    /**
     * 发送消息
     * 对消息加入到消息队列中
     */
    void send(Message message, Session session);

    /**
     * 加入新用户
     *
     * @param imessage
     * @param session
     */
    boolean authClientUser(Message imessage, Session session);

    /**
     * 获取在线用户
     *
     * @param imessage
     * @param session
     */
    void getOnlineUser(Message imessage, Session session);

    /**
     * 销毁客户终端
     *
     * @param session
     */
    void destroySession(Session session);

    /**
     * 无效消息
     *
     * @param session
     */
    void invalidRequest(Session session);

    /**
     * 下线用户
     *
     * @param imessage
     * @param session
     */
    void mOffline(Message imessage, Session session);
}
