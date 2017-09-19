package com.straw.nettycore.jdk;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fengzy on 8/9/2017.
 */
public class TestHashMap {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 10) {
                list.remove(i);
            }
            System.out.println(i);
        }
        int num = 19;
        String binaryString = Integer.toBinaryString(num);
        System.out.println(binaryString);
        System.out.println(1 << 4);//<< 移位 二进制移一位则倍数增大2倍，移4位则是2的四次方，则是2*2*2*2=16
        //这里输出1是因为这个前面的0省略了，
        System.out.println(Integer.toBinaryString(1));

        Map<String, Integer> map = new HashMap<String, Integer>(16);
        for (int i = 0; i < 20; i++) {
            map.put("i" + i, i);
        }
    }

    @Test
    public void test2() {
        Random a = new Random(10);
        Random b = new Random(10);
        System.out.println(a.nextInt());
        System.out.println(b.nextInt());

    }

    @Test
    public void test1() {
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

        Random rand = new Random(40);
        for (int i = 0; i < 1000; i++) {
            int a = rand.nextInt();
            Integer b = map.get(a);
            map.put(a, b == null ? 1 : b + 1);
        }
        System.out.println(map);
    }

    @Test
    public void test4() {
        for (int i = 0; i < 10; i++) {
            test3();
        }
    }

    /**
     * 实现一个概率可调控的开奖
     */
    @Test
    public void test3() {
        double rate = 0.5;//50%
        String rad = "a";//设置开奖的等级概率
        String e = open(rate, "a");
        System.out.println(e);
    }

    private String open(double rate, String rad) {
        Map<String, Double> warks = new HashMap<String, Double>(6);
        Random rand = new Random();
        double r = (1 - rate) / 3;
        //确定中奖的概率
        warks.put("a", rad == "a" ? rate : r);
        warks.put("b", rad == "b" ? rate : r);
        warks.put("c", rad == "c" ? rate : r);
        warks.put("d", rad == "d" ? rate : r);
        //开奖
        int i = rand.nextInt(100);
        System.out.println("实际开出的数字=>" + i);
        //是否中将
        if (i >= 100 * warks.get("a")) {
            return "a";
        }
        if (i >= 100 * warks.get("b") * 2) {
            return "b";
        }
        if (i >= 100 * warks.get("c")) {
            return "c";
        }
        return "d";
    }

}
