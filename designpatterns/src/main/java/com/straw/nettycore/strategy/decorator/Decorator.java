package com.straw.nettycore.strategy.decorator;

/**
 * Created by fengzy on 9/5/2017.
 */
public abstract class Decorator implements Component {
    protected Component component;

    public void setDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        this.component.display();
    }
}
