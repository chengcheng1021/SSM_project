package com.cc.ssm.dao;

import com.cc.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户ID，获取所有角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.cc.ssm.dao.IPermission.findPermissionByRoleId")),
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 新增角色
     * @param role
     */
    @Insert("insert into role(roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role) throws Exception;
}