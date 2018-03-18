package com.straw.nettycore.apply.lock.zkutils;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZkSync {
    private static final String PATH = "/zk/sync";

    public   Result isHanlder(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        if (zooKeeper == null) {
            zooKeeper = getZooKeeper();
        } else if (zooKeeper.getState() != ZooKeeper.States.CONNECTING) {
            zooKeeper = getZooKeeper();
        }
        System.out.println(Thread.currentThread().getName() + "===" + zooKeeper.getState());
        Stat exists = zooKeeper.exists(PATH, false);
        if (exists == null) {
            List<ACL> acls = new ArrayList<ACL>();
            acls.add(new ACL(31, new Id("world", "anyone")));
            zooKeeper.create(PATH, "1".getBytes(), acls, CreateMode.EPHEMERAL);
            return new Result(zooKeeper, true);
        } else {
            new Result(zooKeeper, false);
        }
        return new Result(null, false);

    }

    private synchronized static ZooKeeper getZooKeeper() {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("192.168.2.105:2181", 500000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    // System.out.println("获取连接成功:" + event.getState());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }

}

