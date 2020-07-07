package com.cc.ssm.service;

import com.cc.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 查找所有权限
     * @return
     * @throws Exception
     */
    public List<Permission> findAll() throws Exception;

    /**
     * 新增权限
     * @param permission
     */
    void save(Permission permission) throws Exception;
}
