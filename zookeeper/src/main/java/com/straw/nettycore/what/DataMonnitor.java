package com.straw.nettycore.what;

import org.apache.zookeeper.*;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.data.Stat;

/**
 * @author fengzy
 * @date 3/16/2018
 */
public class DataMonnitor implements Watcher, AsyncCallback.StatCallback{


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
        System.out.println("监控的结果:"+rc);//输出返回的resultCode
        boolean extis = false;

        if (rc==Code.OK.intValue()){
            extis = true;
        }else{
            System.out.println("no ......");
        }

        //再次监控
        zk.exists(path, true, this, null);
        try {
            if (extis){
                byte[] data = zk.getData(path, false, null);
                System.out.println(new String(data));
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("process   ... ");
        dead = false;
        zk.exists(path, true, this, null);
    }
}
