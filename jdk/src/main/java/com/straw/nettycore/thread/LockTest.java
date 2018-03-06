package com.straw.nettycore.thread;

public class LockTest {
    public static void main(String[] args) {
        final User u = new User();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    u.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    u.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
class User{
    private  int count;
    public  void a() throws InterruptedException {
        count=10;
        Thread.sleep(1000);
        System.out.println("a vlaue:"+count);
    }
    public void b() throws InterruptedException {
        count = -10;
        Thread.sleep(1000);
        System.out.println("b value:"+count);
    }
}
