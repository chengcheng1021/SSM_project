package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IRoleDao;
import com.cc.ssm.domain.Permission;
import com.cc.ssm.domain.Role;
import com.cc.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     * 查询所有角色
     *
     * @return
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    /**
     * 新增角色
     *
     * @param role
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 根据ID查询角色
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @throws Exception
     */
    @Override
    public void deleteRoleById(String roleId) throws Exception {
        // 从 user_role 表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        // 从 role_permission 表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        // 从 role 表中删除
        roleDao.deleteRoleById(roleId);
    }

    /**
     * 根据 roleId 查询可以添加的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {

        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
