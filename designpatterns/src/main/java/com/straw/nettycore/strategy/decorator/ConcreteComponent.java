package com.straw.nettycore.strategy.decorator;

/**
 * Created by fengzy on 9/5/2017.
 */
public class ConcreteComponent implements Component {
    @Override
    public void display() {
        System.out.println("display red");
    }
}
