package com.straw.nettycore.apply.distributedlock;

public class LockTest {
    public static void main(String[] args) {

        final ZkLock lock = new ZkLock("192.168.2.105:2181/pk", "id=1");
        final int n = 4;
        for (int i = 0; i < n; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean b = lock.tryLock();
                    if (b) {
                        System.out.println(Thread.currentThread().getName() + ":获得了锁,我要开始执行了,");
                        try {
                            if (finalI < n - 1) {
                                Thread.sleep(1000);
                                lock.unlock();
                                System.out.println(Thread.currentThread().getName() + "执行完了,放开锁");
                            }else{
                                Thread.sleep(10000);
                                lock.unlock();
                                System.out.println("故意放慢点");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在等的获取锁");
                lock.tryLock();
                System.out.println(Thread.currentThread().getName()+"获取了");
                lock.unlock();
            }
        }).start();
    }
}
