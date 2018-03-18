package com.straw.nettycore.apply.lock;

import com.straw.nettycore.apply.lock.zkutils.Result;
import com.straw.nettycore.apply.lock.zkutils.ZkSync;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZkSyncDataCountThread implements Runnable{

    DataMode dataMode;

    public ZkSyncDataCountThread(DataMode dataMode) {
        this.dataMode = dataMode;
    }

    @Override
    public void run() {
        ZooKeeper zooKeeper = null;
        Result hanlder = null;
        ZkSync zkSync = new ZkSync();
        while (true){
            try {
                if ((hanlder=zkSync.isHanlder(zooKeeper))!=null&&hanlder.isResult()){
                    dataMode.addCount();
                    try {
                        hanlder.getZooKeeper().close();
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    zooKeeper = hanlder.getZooKeeper();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
