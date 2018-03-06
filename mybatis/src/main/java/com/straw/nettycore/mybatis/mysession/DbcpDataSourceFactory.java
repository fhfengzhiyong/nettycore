package com.straw.nettycore.mybatis.mysession;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class DbcpDataSourceFactory extends BasicDataSource implements DataSourceFactory {
    Properties properties;
    @Override
    public void setProperties(Properties props) {
        properties = props;
    }

    @Override
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
