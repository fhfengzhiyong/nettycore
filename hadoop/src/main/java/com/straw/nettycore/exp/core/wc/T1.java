package com.straw.nettycore.exp.core.wc;


import org.apache.hadoop.conf.Configuration;

public class T1 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addResource("configuration1.xml");
        configuration.addResource("configuration2.xml");
        String size = configuration.get("size");
        System.out.println(size);
    }
}
