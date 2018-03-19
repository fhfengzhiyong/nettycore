package com.straw.nettycore.mybatis.param;

import com.straw.nettycore.jdbc.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengzy
 * @date 3/19/2018
 */
public class BootStrap {
    @Test
    public void test1(){
        SqlSession sqlSession = SessionFactory.openSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> params = new HashMap<String,Object>();
        Integer[] ids = new Integer[]{};
        params.put("ids", ids);
        List<User> users = userDao.selectUserList(params);
        if (users !=null && users.size()>0){
            for (User user:users){
                System.out.println(user.getName());
            }
        }
    }
}
