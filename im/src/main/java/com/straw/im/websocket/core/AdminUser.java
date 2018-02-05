package com.straw.im.websocket.core;

/**
 * @author fengzy
 * @date 2/5/2018
 */
public class AdminUser {
    private String NickName;
    private String id;

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
