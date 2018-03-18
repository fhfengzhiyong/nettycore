package com.straw.nettycore.common;

/**
 * @author fengzy
 * @date 3/14/2018
 */
public class Outer {

    public void ma(){
        System.out.println("outer ...");
    }

    public class Inner {
       /* Outer outer(){
            return Outer.this;
        }*/
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer);
        Outer.Inner inner =  outer.new Inner();
       // inner.outer().ma();
       // System.out.println(inner.outer());
    }
}
