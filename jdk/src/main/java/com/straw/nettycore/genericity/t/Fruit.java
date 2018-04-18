package com.straw.nettycore.genericity.t;

/**
 * @Author Lanxiaowei
 * @Date 2018-04-13 16:46
 * @Description 这里是类的描述信息
 */
public abstract class Fruit {
    protected String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "这是一个" + this.name;
    }
}
