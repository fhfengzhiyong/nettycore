package com.straw.nettycore.apply.lock;

/**
 * 数据模型
 */
public class DataMode {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     *该方法处理业务逻辑,线程不安全,需要100毫秒的时间出处理.
     * @return
     */
    public   int addCount(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count++;
        return this.count;
    }
}
