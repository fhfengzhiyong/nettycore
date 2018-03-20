package com.straw.nettycore.thread.t4;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author fengzy
 * @date 3/20/2018
 */
public class Latch {
    public static void main(String[] args) {
        int n = 4;
        final CountDownLatch countDownLatch = new CountDownLatch(n);
        for (int i = 0; i < n ; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " running");
                    try {
                        if (finalI > 1) {
                            Thread.sleep(4000);
                        } else {
                            Thread.sleep(3000);
                        }
                        System.out.println(Thread.currentThread().getName() + " end..");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("我在等待...");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始执行了,");
            }
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
