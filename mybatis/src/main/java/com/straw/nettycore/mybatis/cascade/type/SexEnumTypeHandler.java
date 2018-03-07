package com.straw.nettycore.mybatis.cascade.type;

import com.straw.nettycore.mybatis.cascade.model.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fengzy
 * @date 3/7/2018
 */
public class SexEnumTypeHandler implements TypeHandler<Sex> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,sex.getId());
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int anInt = rs.getInt(columnName);
        return Sex.getSex(anInt);
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int rsInt = rs.getInt(columnIndex);
        return Sex.getSex(rsInt);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);
        return Sex.getSex(anInt);
    }
}
