package com.cc.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 密码加密类
     * @param password
     * @return
     */
    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
