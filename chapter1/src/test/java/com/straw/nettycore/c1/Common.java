package com.straw.nettycore.c1;

import org.junit.Test;

/**
 * Created by fengzy on 7/27/2017.
 */
public class Common {

    private int c;

    @Test
    public void test1() {
        int i;
        //System.out.println(i);
        A a = new A();
        System.out.println(a.i);
        FString fs = new FString(new char[]{'a', 'b'});

        A b = new A();
        System.out.println(a.equals(b));
        c = 1;
        System.out.println(c);
        Integer dd = 4;
    }

}

class A {
    int i;
}
