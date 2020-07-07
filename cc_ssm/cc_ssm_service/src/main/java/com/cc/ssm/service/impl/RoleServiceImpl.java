package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IRoleDao;
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
}
