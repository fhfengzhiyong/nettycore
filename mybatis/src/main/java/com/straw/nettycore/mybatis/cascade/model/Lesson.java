package com.straw.nettycore.mybatis.cascade.model;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public class Lesson {
    private int id;
    private int studentId;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
