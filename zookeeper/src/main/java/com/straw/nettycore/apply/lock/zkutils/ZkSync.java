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

    public Result isHanlder(ZooKeeper zooKeeper) {
        try {
            if (zooKeeper == null) {
                System.out.println("没有连接");
                zooKeeper = getZooKeeper();
            } else if (zooKeeper.getState() != ZooKeeper.States.CONNECTING) {
                System.out.println("因为连接失效关闭zk");
                zooKeeper.close();
                zooKeeper = getZooKeeper();
            }
            //保证所有的zk都是可用的
            System.out.println(Thread.currentThread().getName() + "===" + zooKeeper.getState());
            Stat exists = zooKeeper.exists(PATH, false);
            System.out.println("路径:" + exists);
            if (exists == null) {
                List<ACL> acls = new ArrayList<ACL>();
                acls.add(new ACL(31, new Id("world", "anyone")));
                zooKeeper.create(PATH, "1".getBytes(), acls, CreateMode.EPHEMERAL);
                System.out.println("创建成功了,");
                return new Result(zooKeeper, true);
            } else {
                System.out.println("返回一个有zookeeper的结果");
                new Result(zooKeeper, false);
            }
        } catch (KeeperException e) {
            System.out.println(e.getMessage());
            try {
                System.out.println("关闭zk");
                zooKeeper.close();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("没有zookeeper的结果");
        return new Result(null, false);

    }

    private synchronized static ZooKeeper getZooKeeper() {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("172.19.2.81:2183", 3000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    // System.out.println("获取连接成功:" + event.getState());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        return zooKeeper;
    }
}

