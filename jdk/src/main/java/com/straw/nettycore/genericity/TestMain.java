package com.straw.nettycore.genericity;

import org.junit.Test;

public class TestMain {
    public void showGeneric(Generic<?> generic){
        System.out.println(generic.getKey());
    }
    @Test
    public void test1(){
        Generic<String> g = new Generic<String>("straw");
        System.out.println(g.getKey());
        showGeneric(g);
    }
}
