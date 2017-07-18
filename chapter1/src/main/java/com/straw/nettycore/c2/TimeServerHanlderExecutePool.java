package com.straw.nettycore.c2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by fengzy on 7/14/2017.
 */
public class TimeServerHanlderExecutePool {
    private ExecutorService executorService;

    public TimeServerHanlderExecutePool(int maxPoolSize,int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task){
        executorService.execute(task);
    }
}
