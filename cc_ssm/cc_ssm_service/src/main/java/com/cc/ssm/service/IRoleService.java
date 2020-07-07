package com.cc.ssm.service;

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
}
