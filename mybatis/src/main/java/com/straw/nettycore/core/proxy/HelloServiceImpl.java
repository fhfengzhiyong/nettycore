package com.straw.nettycore.core.proxy;

/**
 * @author fengzy
 * @date 3/8/2018
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello :" + name);
    }
}
