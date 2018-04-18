package com.straw.nettycore.genericity.t;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lanxiaowei
 * @Date 2018-04-13 16:49
 * @Description 这里是类的描述信息
 */
public class FruitBasket<T> {
    private List<T> fruits;

    public <F extends T> void addFruit(F fruit) {
        if (this.fruits == null) {
            this.fruits = new ArrayList();
        }
        this.fruits.add(fruit);
    }

    public void print() {
        for (T fruit : this.fruits) {
            System.out.println(fruit);
        }
    }
}
