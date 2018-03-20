package com.straw.nettycore.barriers;

import com.straw.nettycore.watchznode.t3.WatchInstance;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author fengzy
 * @date 3/20/2018
 */
public class SyncPrimitive implements Watcher{
    ZooKeeper zk;
    Integer mutual = -1;
    public SyncPrimitive(String address) {
        if (zk==null){
            try {
                zk = new ZooKeeper(address, 3000, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("-事件:"+event.getState());
        synchronized (mutual){
            mutual.notify();
        }
    }
}
