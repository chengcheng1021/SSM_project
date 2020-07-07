package com.cc.ssm.dao;

import com.cc.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermission {

    /**
     * 根据roleID查找权限
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in(select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;
}
