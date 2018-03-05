package com.straw.nettycore.mybatis.mysession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fengzy
 * @date 3/5/2018
 */
public class SessionFactory {
    static SqlSessionFactory factory;
    public static SqlSessionFactory getSqlSessionFactory(){
        if (factory !=null){
            return factory;
        }
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("t0/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return factory;
    }
}
