package com.straw.nettycore.watchznode.t3;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author fengzy
 * @date 3/19/2018
 */
public class WatchInstance implements Watcher {
    ZooKeeper zooKeeper;
    String path;
    boolean dead;
    DataProcess dataProcess;

    public WatchInstance(ZooKeeper zooKeeper, String path,DataProcess dataProcess) {
        this.zooKeeper = zooKeeper;
        this.path = path;
        this.dataProcess = dataProcess;
        try {
            Stat exists = zooKeeper.exists(path, this);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("event:" + event.getState());
        try {
            Stat exists = zooKeeper.exists(path, this);
            dataProcess.proecssData(zooKeeper);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    interface DataProcess{
        void proecssData(ZooKeeper zooKeeper);
    }
}
