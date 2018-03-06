package com.straw.nettycore.mybatis.automapper;

import org.apache.ibatis.session.SqlSession;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public class RoleTest {
    public static void main(String[] args) {
        SqlSession sqlSession = SessionFactory.openSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.selectById(1);
        role = mapper.selectByIdAndRoneName(1,"strawtest");
        if (role!=null){
            System.out.println(role.getRoleName());
        }
    }
}
