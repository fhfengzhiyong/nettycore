package com.straw.nettycore.jdbc;

import com.straw.nettycore.mybatis.mysession.Sex;

/**
 * @author fengzy
 * @date 3/5/2018
 */
public class User {
    private int id;
    private String email;
    private String name;

    private Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
