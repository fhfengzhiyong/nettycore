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
        Role role = insert(mapper);
        if (role != null) {
            System.out.println(role.getId());
        }
    }

    Role select(RoleMapper mapper) {
        Role role = mapper.selectById(1);
        if (role != null) {
            System.out.println(role.getRoleName());
        }
        return role;
    }

    static Role insert(RoleMapper mapper) {
        Role role = new Role();
        role.setNote("test");
        role.setRoleName("testrolename");
        mapper.insert(role);
        return role;
    }
}
