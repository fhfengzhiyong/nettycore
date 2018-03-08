package com.straw.nettycore.core.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author fengzy
 * @date 3/8/2018
 */
public class HelloServiceCglib implements MethodInterceptor {
    Object target;
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start ...");
        methodProxy.invoke(target, objects);
        System.out.println("end ...");
        return null;
    }
}



















