package com.straw.nettycore.c1;

/**
 * Created by fengzy on 7/26/2017.
 */
public class ValueQuote {
    public static void main(String[] args) {
        String a = "this is a";
        String b = "this is b";
        System.out.println("1:"+"a=[" + a + "]   b=[" + b + "]");
        //System.out.println(a.hashCode());
        conversion(a, b);
        System.out.println("3:"+"a=[" + a + "]   b=[" + b + "]");
    }

    private static void conversion(String a, String b) {
        a = b;
       // System.out.println(a.hashCode());
        System.out.println("2:"+"a=[" + a + "]   b=[" + b + "]");
    }
}
