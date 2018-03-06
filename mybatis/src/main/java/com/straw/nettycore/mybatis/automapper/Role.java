package com.straw.nettycore.mybatis.automapper;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class Role {
    private int id;
    private String roleName;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
