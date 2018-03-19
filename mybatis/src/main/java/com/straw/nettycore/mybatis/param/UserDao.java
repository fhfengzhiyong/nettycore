package com.straw.nettycore.mybatis.param;

import com.straw.nettycore.jdbc.User;

import java.util.List;
import java.util.Map;

/**
 * @author fengzy
 * @date 3/19/2018
 */
public interface UserDao {
    public List<User> selectUserList(Map<String,Object> params);
}
