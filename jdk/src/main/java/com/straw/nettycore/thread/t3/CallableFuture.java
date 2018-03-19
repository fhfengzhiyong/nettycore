package com.straw.nettycore.thread.t3;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author fengzy
 * @date 3/19/2018
 */
public class CallableFuture {
    @Test
    public void t1() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int anInt = new Random().nextInt();
                Thread.sleep(5000);
                return anInt;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = null;
        try {
            integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }

    @Test
    public void t2() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        Integer integer = null;
        try {
            integer = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }
}