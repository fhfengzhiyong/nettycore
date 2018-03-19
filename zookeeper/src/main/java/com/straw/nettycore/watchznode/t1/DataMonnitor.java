package com.straw.nettycore.watchznode.t1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.data.Stat;

/**
 * @author fengzy
 * @date 3/16/2018
 */
public class DataMonnitor implements Watcher, AsyncCallback.StatCallback {


    ZooKeeper zk;
    String path;
    boolean dead;

    public DataMonnitor(ZooKeeper zk, String path) {
        this.zk = zk;
        this.path = path;
        zk.exists(path, true, this, null);
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean extis = false;
        if (rc == Code.OK.intValue()) {
            extis = true;
        } else {
            System.out.println("no ......");
        }
        boolean exists;
        switch (rc) {
            case KeeperException.Code.Ok:
                exists = true;
                break;
            case KeeperException.Code.NoNode:
                exists = false;
                break;
            case KeeperException.Code.SessionExpired:
            case KeeperException.Code.NoAuth:
                dead = true;
                return;
            default:
                // Retry errors
                zk.exists(path, true, this, null);
                return;
        }
        try {

            byte[] data = zk.getData(path, false, null);
            System.out.println("data:"+new String(data));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("process   ... ");
        zk.exists(path, true, this, null);
    }
}
