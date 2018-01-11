package com.straw.nettycore;

import java.io.*;
import java.util.Random;

/**
 * 随机生成11位的数字
 */
public class RandomDataLine {
    public static void main(String[] args) throws IOException {
        File file =new File("a.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        System.out.println("开始写入");
        Random random = new Random(100000000);
        FileOutputStream outputStream = new FileOutputStream(file);
        for (int i = 0; i < 100000; i++) {
            int a = random.nextInt();
            String b = a+"\n";
            outputStream.write(b.getBytes());
        }
        outputStream.close();
    }
}
