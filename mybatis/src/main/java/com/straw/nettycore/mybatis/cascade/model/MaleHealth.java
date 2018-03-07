package com.straw.nettycore.mybatis.cascade.model;

public class MaleHealth extends Student{
    private int id;
    private String item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
