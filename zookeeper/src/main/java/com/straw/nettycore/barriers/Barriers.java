package com.straw.nettycore.barriers;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author fengzy
 * @date 3/20/2018
 */
public class Barriers extends SyncPrimitive {
    Integer size;
    String root;
    String node;

    public Barriers(String address, String root, Integer size) {
        super(address);
        this.root = root;
        this.size = size;
        try {
            Stat exists = zk.exists(root, false);
            if (exists != null) {
                zk.delete(node, exists.getVersion());
            }
            zk.create(root, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        node = Thread.currentThread().getName();
    }

    public boolean enter() throws KeeperException, InterruptedException {
        zk.create(root + "/" + node, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        while (true) {
            synchronized (mutual) {
                List<String> list = zk.getChildren(root, true);
                if (list.size() < size) {
                    mutual.wait();
                } else {
                    return true;
                }
            }
        }
    }

}
