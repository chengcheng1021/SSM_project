package com.cc.ssm.service;

import com.cc.ssm.domain.Permission;
import com.cc.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll() throws Exception;

    /**
     * 新增角色
     * @param role
     */
    void save(Role role) throws Exception;

    /**
     * 根据ID查询角色
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findById(String roleId) throws Exception;

    /**
     * 删除角色
     * @param roleId
     * @throws Exception
     */
    void deleteRoleById(String roleId) throws Exception;

    /**
     * 根据 roleId 查询可以添加的权限
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermission(String roleId) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
