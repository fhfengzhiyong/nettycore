package com.straw.nettycore.mybatis.cascade;

import com.straw.nettycore.mybatis.cascade.mapper.LessonMapper;
import com.straw.nettycore.mybatis.cascade.mapper.StudentCardMapper;
import com.straw.nettycore.mybatis.cascade.mapper.StudentMapper;
import com.straw.nettycore.mybatis.cascade.model.Lesson;
import com.straw.nettycore.mybatis.cascade.model.Student;
import com.straw.nettycore.mybatis.cascade.model.StudentCard;
import org.junit.Test;

import java.util.List;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public class MainTest {
    public static void main(String[] args) {
        StudentMapper studentMapper = SessionFactory.openSqlSession().getMapper(StudentMapper.class);
        Student student = select(studentMapper);
        if (student != null) {
            System.out.println(student.getName());
            System.out.println(student.getSex().getName());
            System.out.println(student.getStudentCard().getCard());
            System.out.println(student.getLessonList().get(0).getName());
        }
    }

    private static Student select(StudentMapper studentMapper) {
        return studentMapper.selectById(1);
    }

    /**
     * 测试学生课程mapper
     */
    @Test
    public void test2(){
        LessonMapper lessonMapper = SessionFactory.openSqlSession().getMapper(LessonMapper.class);
        List<Lesson> lessons = lessonMapper.selectLessonListByStudentId(1);
        if (lessons != null&& lessons.size()>0) {
            for (Lesson lesson : lessons) {
                System.out.println(lesson.getName());
            }
        }
    }

    /**
     * 测试学生卡mapper
     */
    public void test1(){
        StudentCardMapper studentCardMapper = SessionFactory.openSqlSession().getMapper(StudentCardMapper.class);
        StudentCard studentCard = studentCardMapper.selectByStudentId(1);
        if (studentCard != null) {
            System.out.println(studentCard.getCard());
        }
    }
}
