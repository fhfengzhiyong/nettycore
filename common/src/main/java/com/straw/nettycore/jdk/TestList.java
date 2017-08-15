package com.straw.nettycore.jdk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fengzy on 8/9/2017.
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("第" + i + "个");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (o.equals("第15个")) {
                it.remove();
            }
        }
        //这种循环会跳过删除元素的下一个元素
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (i == 2) {
                list.remove(i);
            }
        }
        System.out.println("---------------------");
        //为什么没有报错？因为没进去
        for (String s : list) {
            System.out.println(s);
            if (s.equals("第3个")) {
                list.remove(s);
                System.out.println("4545454");
            }
        }
        //
    }

    @Test
    public void test1() {
        System.out.println(sun.misc.VM.isBooted());
        float a = 3.4f;
        System.out.println(a);

    }


}
