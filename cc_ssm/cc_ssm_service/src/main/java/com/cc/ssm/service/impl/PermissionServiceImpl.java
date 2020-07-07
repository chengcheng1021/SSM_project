package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IPermissionDao;
import com.cc.ssm.domain.Permission;
import com.cc.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    /**
     * 查找所有权限
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    /**
     * 新增权限
     *
     * @param permission
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
