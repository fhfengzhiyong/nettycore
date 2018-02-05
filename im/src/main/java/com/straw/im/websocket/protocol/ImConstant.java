package com.straw.im.websocket.protocol;

/**
 * Created by Administrator on 2017/6/29.
 */
public class ImConstant {
    //用户对象
    public static final String USER_OBJECT = "user_object";
    //客户端消息类型
    public static final String C_TYPE_AUTH = "auth";//用户认证
    public static final String C_TYPE_TEXT = "text";//普通消息
    public static final String C_TYPE_ONLINE_USER = "online_user";//在线用户
    public static final String C_TYPE_MOFFLINE = "m_offline";
    public static final String C_TYPE_NOTICY = "m_notify";//管理员通知
    //服务端消息类型
    public static final String S_TYPE_TEXT = "text";//普通消息
    public static final String S_TYPE_USER_LOGIN = "user_login";//用户登录信息，一个用户
    public static final String S_TYPE_USER_LIST = "user_list";//主动请求时会返回所有用户列表
    public static final String S_TYPE_USER_LOGOUT = "user_logout";//用户登出
    public static final String S_TYPE_M_USER_LOGOUT = "m_user_logout";//强制用户下线
    public static final String S_TYPE_M_NOTIFY = "m_notify";//系统通知
    public static final String S_TYPE_INVALID = "invalid";
    //系统用户
    public static final String S_USER_SYSTEM = "zhenhx";//系统

}
