package com.straw.nettycore.test.cli2netty;

import com.straw.nettycore.test.cli2netty.from.FileSendService;
import com.straw.nettycore.test.cli2netty.from.SendService;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;

/**
 * @author fengzy
 * @date 2/24/2018
 */
public class TestOjbect {
    @Test
    public void t1() {
        try {
            SendService<File> send = new FileSendService();
            File file = new File("D:\\utf.zip");
            try {
                send.send(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询方法的默认修饰符
     */
    @Test
    public void t2() {
        try {
            Class<?> aClass = getClass().getClassLoader().loadClass("com.straw.nettycore.test.cli2netty.from.HttpPostService");

            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("method:" + Modifier.toString(method.getModifiers()));
                System.out.println(method.getName() + "::" + method.getGenericReturnType());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
