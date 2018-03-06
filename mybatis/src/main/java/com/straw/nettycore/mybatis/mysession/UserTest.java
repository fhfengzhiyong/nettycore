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
        if (user != null) {
            System.out.println(user.getEmail());
            System.out.println(user.getSex().getName());
        }
    }

    private User select() {

        SqlSession sqlSession = SessionFactory.openSqlSession();
        String databaseId = sqlSession.getConfiguration().getDatabaseId();
        System.out.println("databaseid:"+  databaseId);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setName("str");
        u.setEmail("4@q.com");
        u.setId(2);
        u.setSex(Sex.MALE);
        //mapper.insert(u);
        User user = mapper.selectById(2);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
}
