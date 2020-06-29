package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static  BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
    public static String encodePassword(String password){

        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String pwd = encodePassword(password);
        // $2a$10$IL8ZgeXGRftEkxJ9RX1sn.2iuQynl845sQ26RHVMHkzqdNM7uz60u
        // 2a$10$D0ABEpLfsZSbWm6pyS0djeqoXqOTddVRU1NFeksyIsQ8Ia4sPa9uG
        System.out.println(pwd);
    }

}
