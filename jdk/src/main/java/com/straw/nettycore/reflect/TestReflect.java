package com.straw.nettycore.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class TestReflect {
    public TestReflect() {
        System.out.println("调用");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> testReflect = Class.forName("com.straw.nettycore.reflect.TestReflect");
        Object instance = testReflect.getDeclaredConstructor().newInstance();
        System.out.println(instance);
    }
}
