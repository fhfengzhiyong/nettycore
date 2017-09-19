package com.straw.nettycore.strategy.decorator;

/**
 * Created by fengzy on 9/5/2017.
 */
public class TestDecotator {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        BlackDecorator blackDecorator = new BlackDecorator();
        GreenDecorator greenDecorator = new GreenDecorator();

        blackDecorator.setDecorator(component);
        greenDecorator.setDecorator(blackDecorator);
        greenDecorator.display();
    }
}
