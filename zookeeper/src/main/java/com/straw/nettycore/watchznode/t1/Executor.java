package com.straw.nettycore.watchznode.t1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author fengzy
 * @date 3/16/2018
 */
public class Executor  implements Watcher ,Runnable{
    String host;
    String path;
    Watcher watcher;
    ZooKeeper zk;
    DataMonnitor dm;


    public Executor(String host, String path) throws IOException {
        this.host = host;
        this.path = path;
        zk = new ZooKeeper(host, 3000, this);
        dm = new DataMonnitor(zk,path);
    }

    public static void main(String[] args) {
        Executor executor = null;
        try {
            new Executor("172.19.2.81:2181", "/app/ab").run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!dm.dead) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println("连接好了,");
        dm.process(event);
    }
}
