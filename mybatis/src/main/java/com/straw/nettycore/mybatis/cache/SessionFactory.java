package com.straw.nettycore.mybatis.cache;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fengzy
 * @date 3/5/2018
 */
class SessionFactory {
    private static SqlSessionFactory factory;
    private static final SessionFactory OBJECT = new SessionFactory();

    /**
     * 私有化,单例时不让使用new方法创建
     */
    private SessionFactory() {
    }

    private static void initSqlSessionFactory() {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("t4/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (OBJECT) {
            if (factory == null) {
                factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            }
        }
    }


    static SqlSession openSqlSession() {
        if (factory == null) {
            initSqlSessionFactory();
        }
        return factory.openSession();
    }
}
