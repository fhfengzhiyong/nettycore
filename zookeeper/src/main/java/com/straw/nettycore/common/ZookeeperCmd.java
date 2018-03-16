package com.straw.nettycore.common;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fengzy
 * @date 3/16/2018
 */
public class ZookeeperCmd {
    @Test
    public void test1() {
        ZooKeeper zk = getZooKeeper();
        final Stat stat = new Stat();
        try {
            zk.getData("/app", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("pro");
                    Event.KeeperState state = event.getState();
                    System.out.println(state);
                }
            }, stat);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stat);
        System.out.println(stat.getDataLength());
        List<ACL> acl = new ArrayList<ACL>();
        String cPath = "/app/ab";
        acl.add(new ACL(123, new Id("digest", "straw:ACFm5rWnnKn9K9RN/Oc8qEYGYDs=")));
        try {

            String s = zk.create(cPath, "ab is child".getBytes(), acl, CreateMode.PERSISTENT);
            System.out.println(s);
            List<String> children = zk.getChildren(cPath, false);
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    System.out.println(children.get(i));
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private ZooKeeper getZooKeeper() {
        String host = "172.19.2.81:2181";
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(host, 600, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("执行了,,,,,,");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(zk.getState());
        return zk;
    }

    @Test
    public void test2() {
        ZooKeeper zk = getZooKeeper();
        zk.addAuthInfo("digest", "straw:1234".getBytes());
        String cPath = "/app/ab";
        List<String> children = null;
        try {
            children = zk.getChildren(cPath, false);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                System.out.println(children.get(i));
            }
        }
    }

    @Test
    public void test3() {
        ZooKeeper zooKeeper = getZooKeeper();
        Stat stat = null;
        try {
            List<ACL> acl = zooKeeper.getACL("/app/ab", stat);
            if (acl != null) {
                for (int i = 0; i < acl.size(); i++) {
                    System.out.println(acl.get(i).getPerms());
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        final ZooKeeper zooKeeper = getZooKeeper();
        Stat stat = new Stat();
        try {
            byte[] data = zooKeeper.getData("/app/ab", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event.getType().getIntValue());
                }
            }, stat);
            String s = new String(data);
            System.out.println(s);
            System.out.println(stat.getAversion());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test5(){
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1204);
        try {
            System.out.println(Runtime.getRuntime().exec("calc"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
