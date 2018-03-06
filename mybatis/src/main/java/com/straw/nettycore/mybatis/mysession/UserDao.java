package com.straw.nettycore.mybatis.mysession;

import com.straw.nettycore.jdbc.User;

/**
 * @author fengzy
 * @date 3/5/2018
 */

public interface UserDao {
    User selectById(int id);

    void insert(User u);
}
