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

        System.out.println("===================this is boundary================================");
        subString(a);
        System.out.println(a);
    }

    private static void conversion(String c, String d) {
        c = d;
        // System.out.println(a.hashCode());
        c = "this is a new value";
        System.out.println("2:" + "a=[" + c + "]   b=[" + d + "]");
    }

    /**
     * 该方法没有任何卵用，SubString返回的是新字符串
     *
     * @param ch
     */
    private static void subString(String ch) {
        String t = ch.substring(2);
        System.out.println(t);
        System.out.println(ch);
    }
}
