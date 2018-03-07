package com.straw.nettycore.mybatis.cache;


import com.straw.nettycore.mybatis.cache.mapper.UserMapper;
import com.straw.nettycore.mybatis.cache.model.User;
import org.apache.ibatis.session.SqlSession;

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
}
