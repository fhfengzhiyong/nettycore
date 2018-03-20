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
    public void test5() {
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1204);
        try {
            System.out.println(Runtime.getRuntime().exec("calc"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        ZooKeeper zooKeeper = getZooKeeper();
        byte[] data = new byte[0];
        try {
            data = zooKeeper.getData("/zk/sb", false, null);
            System.out.println("会执行吗");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new String(data));
    }

    @Test
    public void test7() {
        ZooKeeper zooKeeper = getZooKeeper();
        List<ACL> acls = new ArrayList<ACL>();
        acls.add(new ACL(31, new Id("world", "anyone")));
        try {
            String path = zooKeeper.create("/zk/ab", "dt".getBytes(), acls, CreateMode.PERSISTENT);
            System.out.println(path);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        ZooKeeper zooKeeper = getZooKeeper();
        try {
            Stat exists = zooKeeper.exists("/zk/ac", false);
            System.out.println("是否存在:"+exists);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test8(){
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper("172.19.2.81:2181", 3000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event.getState());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Stat stat = zk.exists("/br", false);
            System.out.println(stat);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
