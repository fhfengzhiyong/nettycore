package com.straw.nettycore.thread.t4;

import org.junit.Test;

import java.util.concurrent.*;

public class CountDownLatchTest {
    @Test
    public void test(){
        final CountDownLatch countDownLatch = new CountDownLatch(4);
       Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                countDownLatch.countDown();
                return 1;
            };
        };
        new Thread(new FutureTask<Integer>(callable)).start();
        try {
            countDownLatch.await(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //@Test
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":我的任务");
            }
        });
        for (int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":正在执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("继续执行");
                }
            }).start();
        }
    }
}
