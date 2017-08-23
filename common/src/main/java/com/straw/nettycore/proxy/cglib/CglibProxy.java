package com.straw.nettycore.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by fengzy on 8/18/2017.
 */
public class CglibProxy implements MethodInterceptor {
    Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] arrs, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始");
        Object p = methodProxy.invokeSuper(o, arrs);
        System.out.println("事务结束");
        return p;
    }


}
