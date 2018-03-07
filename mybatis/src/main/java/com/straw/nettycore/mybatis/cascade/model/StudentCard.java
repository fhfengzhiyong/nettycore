package com.straw.nettycore.mybatis.cascade.model;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public class StudentCard {
    private int id;
    private int studentId;
    private String card;

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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
