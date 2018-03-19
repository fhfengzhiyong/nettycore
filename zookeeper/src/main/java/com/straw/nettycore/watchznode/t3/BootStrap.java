package com.straw.nettycore.watchznode.t3;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author fengzy
 * @date 3/19/2018
 */
public class BootStrap implements Runnable,WatchInstance.DataProcess {
    ZooKeeper zooKeeper;
    String path;
    WatchInstance wi;

    public BootStrap(ZooKeeper zooKeeper, String path) {
        this.zooKeeper = zooKeeper;
        this.path = path;
        wi = new WatchInstance(this.zooKeeper, path,this);
    }

    public static void main(String[] args) throws IOException {
        ZooKeeper zookeeper = getZookeeper();
        new BootStrap(zookeeper, "/zk/ab").run();
    }

    private static ZooKeeper getZookeeper() throws IOException {
        return new ZooKeeper("172.19.2.81:2183", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("开始了请求状态为:" + event.getState());
            }
        });
    }

    /**
     * 守护线程
     */
    @Override
    public void run() {
        synchronized (this) {
            while (!wi.dead){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void proecssData(ZooKeeper zooKeeper) {
        byte[] data = new byte[0];
        try {
            data = zooKeeper.getData("/zk/ab", false, null);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new String (data));
    }
}
