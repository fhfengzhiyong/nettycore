package com.straw.nettycore.strategy.test;

import com.straw.nettycore.strategy.Duck;

/**
 * Created by fengzy on 7/28/2017.
 * 这里定义了一个类，和别的类不同的是他有着red的外表
 */
public class RedInvertedDuck extends Duck {
    @Override
    public void display() {
        System.out.println("i'm red");
    }
}
