package com.straw.nettycore.apply.lock;

import com.straw.nettycore.apply.lock.zkutils.Result;
import com.straw.nettycore.apply.lock.zkutils.ZkSync;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZkSyncDataCountThread implements Runnable {

    DataMode dataMode;

    long sleep = 0;
    public ZkSyncDataCountThread(DataMode dataMode,long sleep) {
        this.dataMode = dataMode;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        ZooKeeper zooKeeper = null;
        Result hanlder = null;
        ZkSync zkSync = new ZkSync();
        long sessionId = 0;
        int i = 0;
        while (true) {
            i++;
            if (zooKeeper != null) {
                System.out.println("zookpper 有值");
                sessionId = zooKeeper.getSessionId();
            }else{
                System.out.println("zookeeper 为null");
            }
            System.out.println(Thread.currentThread().getName() + "第" + i + "次请求重试sessionId:"+sessionId);
            hanlder = zkSync.isHanlder(zooKeeper);
            if (hanlder!= null && hanlder.isResult()) {
                dataMode.addCount();
                System.out.println("进行增加");
                try {
                    hanlder.getZooKeeper().close();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                zooKeeper = hanlder.getZooKeeper();
                if (zooKeeper != null) {
                    System.out.println("赋值给zokk");
                    sessionId = zooKeeper.getSessionId();
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
