package com.straw.nettycore.thread.t1;

import java.util.Random;

/**
 * @author fengzy
 * @date 3/2/2018
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static int value = 0;

    public static class ThreadLocalThread implements Runnable{
        @Override
        public void run() {
            threadLocal.set(new Random(Thread.currentThread().getId()).nextInt());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(Thread.currentThread().getName() + ": threadLocal=%d, value=%d\n", threadLocal.get(), value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadLocalThread());
        Thread t2 = new Thread(new ThreadLocalThread());
        t1.start();
        t2.start();
        t1.join();
    }
}
