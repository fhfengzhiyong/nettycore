package com.straw.nettycore.thread.t5;

/**
 * @author fengzy
 * @date 3/20/2018
 */
public class Wait {
    public static void main(String[] args) {
        final Integer n = -1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (n) {
                    while (true) {
                        System.out.println("waiting");
                        try {
                            n.wait();
                            System.out.println("go on ...");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (n) {
                        n.notify();
                    }
                }
            }
        }).start();

    }
}
