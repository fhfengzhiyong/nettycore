package com.straw.nettycore.core.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author fengzy
 * @date 3/9/2018
 */
@Intercepts({@Signature(type = Executor.class,
        method = "update",
        args ={MappedStatement.class,Object.class}
)})
public class MyPlugin implements Interceptor {
    Properties properties =null;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("执行");
        Object obj = invocation.proceed();
        System.out.println("执行后");
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("框架已经开始获取了....");
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
        System.out.println(properties.get("dbType"));
        System.out.println("参数设置完成");
    }
}
