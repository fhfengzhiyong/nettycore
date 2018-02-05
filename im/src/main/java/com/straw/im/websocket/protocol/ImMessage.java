package com.straw.im.websocket.protocol;

/**
 * Created by Administrator on 2017/6/29.
 */
public class ImMessage {
    //发送者
    private String user;
    //消息内容
    private String message_context;
    //消息时间
    private String message_date;
    //目标用户，空为全部
    private String to_user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage_context() {
        return message_context;
    }

    public void setMessage_context(String message_context) {
        this.message_context = message_context;
    }

    public String getMessage_date() {
        return message_date;
    }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

    public String getTo_user() {
        return to_user;
    }

    public void setTo_user(String to_user) {
        this.to_user = to_user;
    }


}
