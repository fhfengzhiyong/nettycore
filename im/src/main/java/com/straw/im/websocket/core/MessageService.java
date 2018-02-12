package com.straw.im.websocket.core;

import com.straw.im.websocket.protocol.Message;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface MessageService {
    /**
     * 发送消息
     * 对消息加入到消息队列中
     */
    void send(Message message, WebSocketSession session);

    /**
     * 加入新用户
     *
     * @param imessage
     * @param session
     */
    boolean authClientUser(Message imessage, WebSocketSession session);

    /**
     * 获取在线用户
     *
     * @param imessage
     * @param session
     */
    void getOnlineUser(Message imessage, WebSocketSession session);

    /**
     * 销毁客户终端
     *
     * @param session
     */
    void destroySession(WebSocketSession session);

    /**
     * 无效消息
     *
     * @param session
     */
    void invalidRequest(WebSocketSession session);

    /**
     * 下线用户
     *
     * @param imessage
     * @param session
     */
    void mOffline(Message imessage, WebSocketSession session);
}
