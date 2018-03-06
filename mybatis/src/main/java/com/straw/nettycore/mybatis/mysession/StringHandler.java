package com.straw.nettycore.mybatis.mysession;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fengzy
 * @date 3/6/2018
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringHandler implements TypeHandler<String>{
    private Logger log = Logger.getLogger(StringHandler.class);
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        log.debug("执行了 setParameter设置方法");
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        log.debug("执行了 getResult设置方法");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        log.debug("执行了 getResult(ResultSet rs, int columnIndex)设置方法");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.debug("执行了 getResult(CallableStatement cs, int columnIndex)");
        return cs.getString(columnIndex);
    }
}
