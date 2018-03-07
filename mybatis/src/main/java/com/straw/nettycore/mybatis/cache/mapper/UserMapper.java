package com.straw.nettycore.mybatis.cache.mapper;

import com.straw.nettycore.mybatis.cache.model.User;

/**
 * @author fengzy
 * @date 3/5/2018
 */

public interface UserMapper {
    User selectById(int id);

    void insert(User u);
}
