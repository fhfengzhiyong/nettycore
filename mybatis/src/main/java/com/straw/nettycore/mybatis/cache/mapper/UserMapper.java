package com.straw.nettycore.mybatis.cache.mapper;

import com.straw.nettycore.mybatis.cache.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fengzy
 * @date 3/5/2018
 */

public interface UserMapper {
    User selectById(@Param(value = "id") Integer id);

    void insert(User u);


    void update(User user);

    List<User> selectBySex(@Param(value = "list") List<Integer> list);
}
