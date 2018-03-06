package com.straw.nettycore.thread.t2;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class ConnFactory {
    private static ConnFactory connFactory;
    private static Object OBJECT = new Object();

    /**
     * 私有化构造方法
     */
    private ConnFactory() {
    }

    static ConnFactory getConnFactory() {
        if (connFactory == null) {
            init();
        }
        return connFactory;
    }

    private static void init() {
        System.out.println(Thread.currentThread().getName() + "  init:facotry");
        synchronized (OBJECT) {
            if (connFactory == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connFactory = new ConnFactory();
            }
        }
    }
}
