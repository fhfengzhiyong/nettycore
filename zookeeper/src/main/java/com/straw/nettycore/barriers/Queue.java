package com.straw.nettycore.barriers;

import com.alibaba.fastjson.JSONObject;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author fengzy
 * @date 3/20/2018
 */
public class Queue<T extends Object> extends SyncPrimitive {
    String root;

    public Queue(String address, String root) {
        super(address);
        this.root = root;
        if (zk != null) {
            try {
                Stat exists = zk.exists(root, false);
                if (exists != null) {
                    zk.delete(root, exists.getVersion());
                }
                zk.create(root, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生产
     *
     * @param t 数据
     * @return
     */
    public boolean produce(T t) {
        byte[] bytes = JSONObject.toJSONString(t, false).getBytes();
        try {
            zk.create(root + "/element", bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public T consume() {
        T t = null;
        synchronized (mutual) {
            while (true) {
                try {
                    List<String> list = zk.getChildren(root, false);
                    if (list.size() == 0) {
                        mutual.wait();
                    } else {
                        Integer min = new Integer(list.get(0).substring(7));
                        for (String s : list) {
                            Integer temp = new Integer(s);
                            if (min > temp) {
                                min = temp;
                            }
                        }
                        byte[] data = zk.getData(root + "/element" + min, false, null);
                        t = (T) JSONObject.parseObject(new String(data), t.getClass());
                        return t;
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
