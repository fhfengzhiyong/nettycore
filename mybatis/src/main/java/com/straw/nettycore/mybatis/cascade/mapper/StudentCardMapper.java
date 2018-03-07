package com.straw.nettycore.mybatis.cascade.mapper;

import com.straw.nettycore.mybatis.cascade.model.StudentCard;
import org.apache.ibatis.annotations.Param;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public interface StudentCardMapper {
    StudentCard selectByStudentId(@Param(value = "studentId")int studentId);
}
