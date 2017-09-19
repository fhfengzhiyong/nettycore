package com.straw.nettycore.strategy.decorator;

import java.text.DecimalFormat;

/**
 * Created by fengzy on 9/5/2017.
 */
public class GreenDecorator extends Decorator {

    @Override
    public void display() {
        super.display();
        System.out.println("我要白色");
    }
}

class BlackDecorator extends Decorator {
    @Override
    public void display() {
        super.display();
        System.out.println("黑色");
    }
}
