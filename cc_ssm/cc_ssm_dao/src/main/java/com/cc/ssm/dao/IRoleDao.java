package com.cc.ssm.dao;

import com.cc.ssm.domain.Permission;
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
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.cc.ssm.dao.IPermissionDao.findPermissionByRoleId")),
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

    /**
     * 根据ID查询角色
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.cc.ssm.dao.IPermissionDao.findPermissionByRoleId")),
    })
    Role findById(String roleId) throws Exception;

    /**
     * 从 user_role 表中删除
     * @param roleId
     */
    @Delete("delete from users_role where roleId = #{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId) throws Exception;

    /**
     * 从 role_permission 表中删除
     * @param roleId
     */
    @Delete("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId) throws Exception;

    /**
     * 从 role 表中删除
     * @param roleId
     */
    @Delete("delete from role where id = #{roleId}")
    void deleteRoleById(String roleId) throws Exception;

    /**
     * 根据 roleId 查询可以添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId) throws Exception;
}