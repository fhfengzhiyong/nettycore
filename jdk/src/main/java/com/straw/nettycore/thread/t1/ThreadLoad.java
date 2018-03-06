package com.straw.nettycore.thread.t1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(new ThreadLoad());
        printThreadName();
    }

    private static void printThreadName() {
        System.out.println("thread name:" + Thread.currentThread().getName());
    }
}
