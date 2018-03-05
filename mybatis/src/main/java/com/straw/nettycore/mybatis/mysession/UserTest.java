package com.straw.nettycore.mybatis.mysession;

import com.straw.nettycore.jdbc.User;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * @author fengzy
 * @date 3/5/2018
 */
public class UserTest {
    public static void main(String[] args) {
        String s = DateUtils.addDays(new Date(), 4).toString();
        System.out.println(s);
        UserTest test = new UserTest();
        User user = test.select();
        if (user!=null){
            System.out.println(user.getEmail());
        }
    }

    private User select() {
        SqlSession sqlSession = SessionFactory.getSqlSessionFactory().openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectById(1);
        sqlSession.close();
        return user;
    }
}
