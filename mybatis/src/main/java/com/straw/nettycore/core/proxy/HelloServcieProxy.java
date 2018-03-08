package com.straw.nettycore.core.proxy;

import javax.naming.spi.ObjectFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author fengzy
 * @date 3/8/2018
 */
public class HelloServcieProxy implements InvocationHandler {


    Object o;

    public HelloServcieProxy(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我要开始执行了");
        method.invoke(o, args);
        System.out.println("执行完了哦");
        return null;
    }
}
