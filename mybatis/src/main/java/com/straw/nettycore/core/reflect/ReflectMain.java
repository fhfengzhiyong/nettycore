package com.straw.nettycore.core.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fengzy
 * @date 3/8/2018
 */
public class ReflectMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.straw.nettycore.core.reflect.Hello");
        Object o = aClass.newInstance();
        Method sysHello = o.getClass().getMethod("sayHello", String.class);
        sysHello.invoke(o,"straw");

    }
}
