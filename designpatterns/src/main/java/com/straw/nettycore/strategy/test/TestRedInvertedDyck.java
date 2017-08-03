package com.straw.nettycore.strategy.test;

import com.straw.nettycore.strategy.Duck;
import com.straw.nettycore.strategy.impl.GaGaCry;
import com.straw.nettycore.strategy.impl.InvertedFay;

/**
 * Created by fengzy on 7/28/2017.
 * 所谓的面向接口编程是使用的时候更多的使用接口，调用接口的方法，不是具体的某个实现类，
 */
public class TestRedInvertedDyck {
    public static void main(String[] args) {
        Duck duck = new RedInvertedDuck();
        duck.setCryBehavior(new GaGaCry());
        duck.setFayBehavior(new InvertedFay());
        duck.display();
        duck.cry();
    }
}
