package com.straw.nettycore.mybatis.cache;


import com.straw.nettycore.mybatis.cache.mapper.UserMapper;
import com.straw.nettycore.mybatis.cache.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CacheMain
{
    public static void main(String[] args) {
        SqlSession sqlSession = SessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        user = userMapper.selectById(1);
        System.out.println("---2---");
        sqlSession.close();
        SqlSession sqlSession2 = SessionFactory.openSqlSession();
        UserMapper user2Mapper = sqlSession2.getMapper(UserMapper.class);
        user2Mapper.selectById(1);
        user2Mapper.selectById(1);
        if (user != null) {
            System.out.println(user.getName());
        }
    }
    @Test
    public void test1(){
        SqlSession sqlSession = SessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user =new User();
        user.setId(1);
        user.setName("jeon");
        userMapper.update(user);
        sqlSession.commit();
    }

    /**
     * test foreach
     */
    @Test
    public void test2(){
        SqlSession sqlSession = SessionFactory.openSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        List<User> users = userMapper.selectBySex(list);
    }
}
