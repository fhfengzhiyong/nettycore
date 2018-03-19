package com.straw.nettycore.apply.lock;

import org.junit.Test;

public class DataRun {
    /**
     * 生成100个现场去完成数据的数据的增加,用于统计线程数量
     * 发现运行结果总是小于线程数量,
     * 当com.straw.nettycore.apply.lock.DataMode#addCount()使用了synchronize,同样也不能达到同步?因为主线程退出了,
     * 使用synchronized 对对象方法处理可以实现同步,
     */
    @Test
    public  void test1(){
        int threadCount = 100;
        DataMode dataMode = new DataMode();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new DataCountThread(dataMode));
            thread.start();
         /*   try {
                //主线程等待线程执行完成,再继续执行
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("执行的线程:"+i);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总数:"+dataMode.getCount());
    }
    @Test
    public void test3(){
        DataMode dataMode = new DataMode();
        Thread thread = new Thread(new ZkSyncDataCountThread(dataMode,10));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总数"+dataMode.getCount());
    }
    @Test
    public void test2(){
        int threadCount = 100;
        DataMode dataMode = new DataMode();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ZkSyncDataCountThread(dataMode,i));
            thread.setName("thread-"+i);
            thread.start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总数:"+dataMode.getCount());
    }
    @Test
    public void test4()  {
        DataMode dataMode = new DataMode();
        int threadCount = 10;
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new T(dataMode));
            thread.start();
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dataMode.getCount());
    }
}

