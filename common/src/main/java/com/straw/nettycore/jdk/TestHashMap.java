package com.straw.nettycore.jdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
