package com.straw.nettycore.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fengzy on 8/18/2017.
 */
public class InvoProxy implements InvocationHandler {
    Object target;

    public Object bind(Object o) {
        this.target = o;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前");
        Object re = method.invoke(target, args);
        System.out.println("调用之后");
        return re;
    }
}
