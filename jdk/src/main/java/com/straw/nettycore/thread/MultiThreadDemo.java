package com.straw.nettycore.thread;

import java.util.concurrent.locks.Lock;

/**
 * @author fengzy
 * @date 3/1/2018
 */
public class MultiThreadDemo {
    public static class Number {
        private int count;
        Object object = new Object();

        /**
         * count 属于类的变量,不能保证
         *
         * @throws InterruptedException
         */
        synchronized void increase() throws InterruptedException {
            System.out.println("in ");
            count = 10;
            System.out.println(Thread.currentThread().getState());
            Thread.sleep(3000);
            System.out.println("increase value:" + count);
            System.out.println("out");
        }

        void decrease() throws InterruptedException {
            System.out.println("2 in ");
            count = -10;
            Thread.sleep(1000);
            System.out.println("decrease value:" + count);
            System.out.println("2 out");
        }
    }

    public static void main(String[] args) {
        final Number number = new Number();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    number.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    number.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
