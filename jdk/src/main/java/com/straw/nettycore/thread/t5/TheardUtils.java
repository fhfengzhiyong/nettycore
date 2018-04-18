package com.straw.nettycore.thread.t5;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author fengzy
 * @date 4/9/2018
 */
public class TheardUtils {
    @Test
    public void t1() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30, 100, TimeUnit.SECONDS, workQueue);
        threadPoolExecutor.getActiveCount();
    }
}
