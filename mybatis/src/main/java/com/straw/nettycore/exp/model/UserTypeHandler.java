package com.straw.nettycore.exp.model;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeHandler implements TypeHandler {
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        System.out.println(parameter);
    }

    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println(columnName);
        return null;
    }

    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println(columnIndex);
        return null;
    }

    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println(columnIndex);
        return null;
    }
}
