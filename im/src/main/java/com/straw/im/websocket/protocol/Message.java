package com.straw.im.websocket.protocol;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Message {
    String message_context;
    String from_user;
    String from_user_nick;
    String to_user;
    String type;
    String message_date;

    public String getFrom_user_nick() {
        return from_user_nick;
    }

    public void setFrom_user_nick(String from_user_nick) {
        this.from_user_nick = from_user_nick;
    }

    public String getMessage_date() {
        return message_date;
    }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage_context() {
        return message_context;
    }

    public void setMessage_context(String message_context) {
        this.message_context = message_context;
    }

    public String getFrom_user() {
        return from_user;
    }

    public void setFrom_user(String from_user) {
        this.from_user = from_user;
    }

    public String getTo_user() {
        return to_user;
    }

    public void setTo_user(String to_user) {
        this.to_user = to_user;
    }
}
