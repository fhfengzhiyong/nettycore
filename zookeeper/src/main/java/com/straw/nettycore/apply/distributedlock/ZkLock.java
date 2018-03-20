package com.straw.nettycore.apply.distributedlock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 初始化锁的时候判断下该锁是否存在,否则可能进入死锁
 */
public class ZkLock extends BaseLock implements Lock, Watcher {
    String root = "";

    public ZkLock(String host, String lock) {
        super(host, lock);
  /*      if (zk != null) {
           // root = getRoot();
            try {
             //   zk.create(root, new byte[]{1}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public void lock() {
        try {
            synchronized (mutual) {
                while (true) {
                    Stat exists = zk.exists(root + "/" + lock, this);
                    if (exists != null) {
                        mutual.wait();
                    } else {
                        zk.create(root + "/" + lock, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                        return;
                    }
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            synchronized (mutual) {
                while (true) {
                    Stat exists = zk.exists(root + "/" + lock, this);
                    if (exists != null) {
                        mutual.wait();
                    } else {
                        zk.create(root + "/" + lock, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                        return true;
                    }
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        try {
            zk.delete(root + "/" + lock, -1);
          /*  List<String> children = zk.getChildren(root, false);
            if (children != null && children.size() == 0) {
                zk.delete(root,-1);
                System.out.println("删除");
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public String getRoot() {
        String name = "/" + Thread.currentThread().getName() + System.currentTimeMillis();
        while (true) {
            try {
                Stat exists = zk.exists(name, false);
                if (exists == null) {
                    return name;
                } else {
                    name = "/" + Thread.currentThread().getName() + System.currentTimeMillis();
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent event) {
        synchronized (mutual) {
            mutual.notify();
        }
    }
}
