package com.straw.nettycore.barriers;

import org.apache.zookeeper.KeeperException;

/**
 * @author fengzy
 * @date 3/20/2018
 */
public class BarriersTest {
    public static void main(String[] args) {
        int n = 4;
        final Barriers barriers = new Barriers("172.19.2.81:2181", "/br", 4);
        for (int i = 0; i < n; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("开始执行一些事情");
                        Thread.sleep(3000);
                        System.out.println("执行完了,到达栅栏");
                        barriers.enter();
                        System.out.println("已通过栅栏,继续执行.");
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
