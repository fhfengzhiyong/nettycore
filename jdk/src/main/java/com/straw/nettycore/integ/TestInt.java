package com.straw.nettycore.integ;

import org.junit.Test;

import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 8/8/2017.
 */
public class TestInt {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
    }

    @Test
    public void test1(){

        System.out.println(Integer.toBinaryString(-128));
    }
}
