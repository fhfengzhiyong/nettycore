package com.straw.nettycore.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author fengzy
 * @date 3/9/2018
 */
public class TestModifier {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<Appel> appelClass = Appel.class;
        Method[] methods = appelClass.getMethods();
        for (Method method:methods){
            System.out.println(method.getName()+":"+Modifier.toString(method.getModifiers()));
        }
        Class<Appel> aClass = (Class<Appel>) Class.forName("com.straw.nettycore.reflect.Appel");
        Appel appel = appelClass.newInstance();

    }
}

class Appel{
    private int mo;
    public String name;
    protected String taste;
    boolean isGMO;
}