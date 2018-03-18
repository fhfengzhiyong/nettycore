package com.straw.nettycore.apply.lock;

public class DataCountThread  implements Runnable{
    DataMode dataMode;

    public DataCountThread(DataMode dataMode) {
        this.dataMode = dataMode;
    }

    @Override
    public void run() {
        dataMode.addCount();
    }
}
