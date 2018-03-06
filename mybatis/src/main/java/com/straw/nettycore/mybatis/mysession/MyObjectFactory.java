package com.straw.nettycore.mybatis.mysession;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class MyObjectFactory extends DefaultObjectFactory {
    @Override
    public void setProperties(Properties properties) {
        System.out.println("设置了属性");
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        System.out.println("创建了对象");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        System.out.println("创建对象");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

}
