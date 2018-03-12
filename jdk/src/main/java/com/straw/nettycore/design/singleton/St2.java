package com.straw.nettycore.design.singleton;

/**
 * 这种方式可以达到只有一个实例.
 * @author fengzy
 * @date 3/12/2018
 */
public class St2 {
    private static St2 st2 = null;

    public static synchronized St2 getSt2() {
        if (st2 == null) {
            st2 = new St2();
        }
        return st2;
    }
}
