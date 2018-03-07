package com.straw.nettycore.mybatis.cascade.mapper;

import com.straw.nettycore.mybatis.cascade.model.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public interface LessonMapper {
    List<Lesson> selectLessonListByStudentId(@Param(value = "studentId") int id);
}
