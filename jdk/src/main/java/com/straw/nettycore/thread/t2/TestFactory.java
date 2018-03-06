package com.straw.nettycore.thread.t2;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class TestFactory {
    public static void main(String[] args) {
        Thread t1 = new Thread(new FacotryThread());
        Thread t2 = new Thread(new FacotryThread());
        Thread t3 = new Thread(new FacotryThread());
        t1.start();
        t2.start();
        t3.start();

    }


}

class FacotryThread implements Runnable{
    @Override
    public void run() {
        ConnFactory connFactory = ConnFactory.getConnFactory();
        System.out.println(Thread.currentThread().getName()+":"+connFactory.toString());
    }
}
