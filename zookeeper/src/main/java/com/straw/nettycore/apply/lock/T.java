package com.straw.nettycore.apply.lock;

public class T implements Runnable {
    DataMode dataMode ;

    public T(DataMode dataMode) {
        this.dataMode = dataMode;
    }

    @Override
    public void run() {
        DistributedLock lock   = new DistributedLock("192.168.2.105:2181","lock");
        lock.lock();
        dataMode.getCount();
        //共享资源
        if(lock != null) {
            lock.unlock();
        }
    }
}
