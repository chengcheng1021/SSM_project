package com.cc.ssm.dao;

import com.cc.ssm.domain.Role;
import com.cc.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    /**
     * 根据姓名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.cc.ssm.dao.IRoleDao.findRoleByUserId")),
    })
    public UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 新增用户
     * @param userInfo
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.cc.ssm.dao.IRoleDao.findRoleByUserId")),
    })
    UserInfo findById(String id) throws Exception;

    /**
     * 根据 用户id 查询可以添加的角色
     * @param userId
     * @return
     */
    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(userId, roleId) values(#{userId}, #{roleId})")
    void addRoleToUser(String userId, String roleId) throws Exception;
}
