package com.straw.nettycore.blogcase.basexml;

import com.straw.nettycore.blogcase.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 9/6/2017.
 */
public class TestMyBatisXml {
    public static void main(String[] args) throws IOException {
        String resource  = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        Blog blog =  session.selectOne("com.straw.nettycore.blogcase.basexml.BlogMapper.selectBlog",1);
        System.out.println(blog.getName());
    }
}
