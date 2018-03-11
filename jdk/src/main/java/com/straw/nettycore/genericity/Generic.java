package com.straw.nettycore.genericity;

public class Generic<T> {
    public Generic(T key) {
        this.key = key;
    }

    private T key;
    public T getKey(){
        return key;
    }
}
