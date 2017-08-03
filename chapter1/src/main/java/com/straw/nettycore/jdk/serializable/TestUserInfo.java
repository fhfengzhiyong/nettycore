package com.straw.nettycore.jdk.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by fengzy on 7/25/2017.
 */
public class TestUserInfo {
    public static void main(String[] args) throws IOException {
        UserInfo userInfo =
                new UserInfo("增加了用户可以选择使用哪个",28);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(userInfo);
        os.flush();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is :" + b.length);
        System.out.println("The byte array serializable length is " + userInfo.codeC().length);
    }
}
