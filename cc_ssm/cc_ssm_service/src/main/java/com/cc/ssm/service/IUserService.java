package com.cc.ssm.service;

import com.cc.ssm.domain.Role;
import com.cc.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 新增用户
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 查询指定ID用户
     * @param id
     * @return
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 根据 用户id 查询可以添加的角色
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId) throws Exception;
}
