package com.straw.nettycore.apply.lock.zkutils;

import org.apache.zookeeper.ZooKeeper;

public class Result {
    ZooKeeper zooKeeper;
    boolean result;

    public Result(ZooKeeper zooKeeper, boolean result) {
        this.zooKeeper = zooKeeper;
        this.result = result;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
