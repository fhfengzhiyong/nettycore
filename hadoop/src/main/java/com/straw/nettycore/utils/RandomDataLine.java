package com.straw.nettycore.utils;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * 随机生成11位的数字
 */
public class RandomDataLine {

    public static void randomDataLine() throws IOException {
        File file = new File("a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println("开始写入");
        Random random = new Random(100000000);
        FileOutputStream outputStream = new FileOutputStream(file);
        for (int i = 0; i < 100000; i++) {
            int a = random.nextInt();
            String b = a + "\n";
            outputStream.write(b.getBytes());
        }
        outputStream.close();
    }

    /**
     * 创建一个生成固定格式数字的文件
     * 模拟年和气温
     * key为年
     * value对应的为气温
     */
    public static void createFileWithNum() throws IOException {
        //随机生成年 1949-2018
        long start = System.currentTimeMillis();

        File file = new File("b.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file, true);
        BufferedOutputStream bof = new BufferedOutputStream(outputStream);
        for (int i = 0; i < 10000000; i++) {
            //随机生成气温
            byte[] bytes = (randomSectionNum(1949, 2018) + "" + randomSectionNum(1, 50) + "\n").getBytes();
            //outputStream.write(bytes);//24秒
            bof.write(bytes);//8秒
        }
        bof.flush();
        bof.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);

    }

    public static void main(String[] args) throws IOException {
        createFileWithNum();
    }

    /**
     * 生成区间数字
     *
     * @param min
     * @param max
     */
    public static int randomSectionNum(int min, int max) {
        double send = ((double) min) / max;
        boolean b = false;
        while (!b) {
            double random1 = Math.random();
            if (random1 <= send) {
                continue;
            }
            b = true;
            int value = (int) (random1 * max);
            return value;
        }
        return 0;
    }
}
