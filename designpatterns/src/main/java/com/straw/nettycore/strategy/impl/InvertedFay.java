package com.straw.nettycore.strategy.impl;

import com.straw.nettycore.strategy.FlyBehavior;

/**
 * Created by fengzy on 7/28/2017.
 */
public class InvertedFay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i'm fly inverted.");
    }
}
