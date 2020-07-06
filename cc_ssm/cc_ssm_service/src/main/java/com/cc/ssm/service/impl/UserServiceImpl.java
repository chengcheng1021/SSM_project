package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IUserDao;
import com.cc.ssm.domain.UserInfo;
import com.cc.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理自己的用户对象封装成 UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), null);
        return user;
    }
}
