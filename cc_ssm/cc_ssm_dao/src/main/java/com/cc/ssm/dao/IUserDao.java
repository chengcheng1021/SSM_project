package com.cc.ssm.dao;

import com.cc.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {

    /**
     * 根据姓名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    public UserInfo findByUsername(String username) throws Exception;
}
