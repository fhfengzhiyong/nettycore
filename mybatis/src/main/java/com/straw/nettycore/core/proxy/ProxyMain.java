package com.straw.nettycore.core.proxy;

import java.lang.reflect.Proxy;

/**
 * @author fengzy
 * @date 3/8/2018
 */
public class ProxyMain {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();

        HelloService proxy =
                (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                        helloService.getClass().getInterfaces(),
                        new HelloServcieProxy(helloService));
        proxy.sayHello("straw");
        HelloService cglibService = (HelloService) new HelloServiceCglib().getInstance(helloService);
        cglibService.sayHello("big cglib");
    }
}
