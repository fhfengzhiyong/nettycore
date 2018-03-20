package com.straw.nettycore.apply.distributedlock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class BaseLock {
    ZooKeeper zk;
    String lock;
    Integer mutual;
    public BaseLock(String host,String lock) {
        this.lock = lock;
        mutual = -1;
        if (zk == null) {
            try {
                zk = new ZooKeeper(host, 3000, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        System.out.println("建立好连接");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
