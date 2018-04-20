package com.straw.nettycore.config.slf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fengzy
 * @date 4/20/2018
 */
public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("hello world!");
    }
}
