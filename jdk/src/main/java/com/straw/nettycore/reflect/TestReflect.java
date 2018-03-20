package com.straw.nettycore.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class TestReflect<T> {
    public TestReflect() {
        System.out.println("调用");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> testReflect = Class.forName("com.straw.nettycore.reflect.TestReflect");
        Object instance = testReflect.getDeclaredConstructor().newInstance();
        System.out.println(instance);
    }
    @Test
    public void test(){
        TestReflect<Integer> testReflect = new TestReflect<Integer>();
        System.out.println(((ParameterizedType)testReflect.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        //testReflect.getClazz();
    }
    public void getClazz(){
        System.out.println(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
