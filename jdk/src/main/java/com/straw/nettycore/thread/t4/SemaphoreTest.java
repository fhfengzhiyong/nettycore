package com.straw.nettycore.thread.t4;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        int N = 8;
        for (int i=0;i<N;i++) {
            new Thread( new Worker( semaphore,i)).start();
        }
    }

    static class Worker implements Runnable{
        Semaphore semaphore;
        int i;

        public Worker(Semaphore semaphore, int i) {
            this.semaphore = semaphore;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+"正在工作");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+"工作完了");
            semaphore.release();
        }
    }
}
