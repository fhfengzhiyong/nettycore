package com.straw.nettycore.config;

import org.slf4j.LoggerFactory;

/**
 * Created by fengzy on 9/12/2017.
 */
public class FirstClass {
    public static void main(String[] args) {
        final ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(FirstClass.class);
        logger.debug("Hello world.");
        logger.info(logger.hashCode() + "");
      /*  new Thread(new Runnable() {
            public void run() {
                logger.info("我是测试");
                System.out.println("我是新线程");
            }
        }).start();*/

        /*LoggerContext factory = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger logger1 = factory.getLogger(FirstClass.class);
        logger1.info(logger1.hashCode()+"");
        StatusPrinter.print(factory);*/
    }
}
