package com.straw.nettycore.thread;

/**
 * @author fengzy
 * @date 2/26/2018
 */
public class ThreadLoad implements Runnable {
    @Override
    public void run() {
        printThreadName();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadLoad());
        thread.start();
        printThreadName();
    }

    public static void printThreadName() {
        System.out.println("thread name:" + Thread.currentThread().getName());
    }
}
