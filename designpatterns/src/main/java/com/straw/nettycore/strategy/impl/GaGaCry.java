package com.straw.nettycore.strategy.impl;

import com.straw.nettycore.strategy.CryBehavior;

/**
 * Created by fengzy on 7/28/2017.
 */
public class GaGaCry implements CryBehavior {
    @Override
    public void cry() {
        System.out.println("i'm cry gaga");
    }
}
