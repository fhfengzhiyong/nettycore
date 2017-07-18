package com.straw.nettycore.c2;

import org.omg.SendingContext.RunTime;

/**
 * Created by fengzy on 7/14/2017.
 */
public class Common {
    public static void main(String[] args) {
        //
        System.out.println(Runtime.getRuntime().availableProcessors());
        Runtime r = Runtime.getRuntime();
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024+"==="+r.maxMemory()/1024/1024+" === " +r.totalMemory()/1024/1024);
    }
}
