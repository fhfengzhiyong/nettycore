package com.straw.nettycore.watchznode.t2;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author fengzy
 * @date 3/19/2018
 */
public class SimpleWatch implements Watcher, Runnable {
    static SimpleWatch simpleWatch;

    ZooKeeper zookeeper;
    static boolean dead;//有并发问题,

    public static void main(String[] args) {
        Thread thread = new Thread(new SimpleWatch());
        thread.start();
        try {
            Object o = new Object();
            synchronized (o) {
                while (!dead) {
                    o.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            zookeeper = getZookeeper();
        } catch (IOException e) {
            e.printStackTrace();
        }
        simpleWatch = new SimpleWatch();
        try {
            Stat exists = zookeeper.exists("/zk/ab", simpleWatch);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println("通知的状态:"+event.getState());
        try {
            //重新放置watch
            System.out.println("sim："+simpleWatch);
            Stat exists = zookeeper.exists("/zk/ab", simpleWatch);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  getData(zookeeper);
    }

    private void getData(ZooKeeper zookeeper) {
        System.out.println("滴啊用了没");
        try {
            byte[] data = zookeeper.getData("/zk/ab", false, null);
            System.out.println("数据为:"+new String(data));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ZooKeeper getZookeeper() throws IOException {
        return new ZooKeeper("172.19.2.81:2183", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("开始了请求状态为:" + event.getState());
            }
        });
    }
}
