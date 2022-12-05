package com.yy.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Base64;

@SpringBootTest
public class PasswordTest {
    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void encode(){
        String password = "yy:admin";
        password = passwordEncoder.encode(password);

        System.out.println(password);
    }

    @Test
    public void base64(){
        String password = "yy:admin";
        password = Base64.getEncoder().encodeToString(password.getBytes());

        System.out.println(password);
    }

}
