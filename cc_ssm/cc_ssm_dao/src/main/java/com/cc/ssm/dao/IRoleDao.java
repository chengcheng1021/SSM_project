package com.cc.ssm.dao;

import com.cc.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据用户ID，获取所有角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;
}