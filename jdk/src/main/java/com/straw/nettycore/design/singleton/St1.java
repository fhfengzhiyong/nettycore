package com.straw.nettycore.design.singleton;

/**
 * 这种形式在类加载的时候直接创建,随处都可以使用
 * @author fengzy
 * @date 3/12/2018
 */
public class St1 {
    private static St1 st1 = new St1();

    public static St1 getSt1() {
        return st1;
    }
}
