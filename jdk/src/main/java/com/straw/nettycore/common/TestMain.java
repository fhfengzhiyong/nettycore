package com.straw.nettycore.common;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author fengzy
 * @date 4/20/2018
 */
public class TestMain {
    @Test
    public void t1() {
        ServiceLoader<Fruit> load = ServiceLoader.load(Fruit.class);
        for (Fruit aLoad : load) {
            System.out.println(aLoad.getName());
        }
    }
}
