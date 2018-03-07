package com.straw.nettycore.mybatis.cascade.mapper;

import com.straw.nettycore.mybatis.cascade.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public interface StudentMapper {
    Student selectById(@Param(value = "id") int id);
}
