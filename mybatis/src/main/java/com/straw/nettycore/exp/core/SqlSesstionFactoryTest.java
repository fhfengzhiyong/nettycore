package com.straw.nettycore.exp.core;


import com.straw.nettycore.exp.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSesstionFactoryTest {
    public static void main(String[] args) throws Exception
    {
        String resouce="mybatis-config.xml";
        InputStream is= Resources.getResourceAsStream(resouce);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        System.out.println(sqlSessionFactory.getConfiguration());
        System.out.println(sqlSessionFactory.getConfiguration().isSafeRowBoundsEnabled());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过源码可知放进去的是sirng和MappedStatement mappedStatements 参数
        //   String id = context.getStringAttribute("id");根据 statement中的id就是配置文件中的id,
        //分析参数应该怎么传,
        User user = sqlSession.selectOne("com.straw.nettycore.exp.model.User.selectUserDetail","1");
        if (user!= null){
            System.out.println(user.getUsername());
        }
    }
}
