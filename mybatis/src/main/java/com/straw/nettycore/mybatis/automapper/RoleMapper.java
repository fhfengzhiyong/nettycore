package com.straw.nettycore.mybatis.automapper;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public interface RoleMapper
{
    public Role selectById(int id);

    Role selectByIdAndRoneName(int id, String roleName);
}
