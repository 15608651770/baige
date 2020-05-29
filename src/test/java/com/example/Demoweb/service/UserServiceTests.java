package com.example.Demoweb.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.entity.UserLoginLog;
import com.example.Demoweb.service.ex.ServiceException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("service");
            user.setPassword("1234");
            user.setCellphone("13800138003");
            user.setEmail("service@163.com");
            userService.reg(user);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
        }
    }

    @Test
    public void login() {
        try {
            String username = "root";
            String password = "1234";
            User result = userService.login(username, password);
            System.err.println("OK.");
            System.err.println(result);
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
    @Test
    public void loginReg() {
        try {
            User user = new User();
            user.setUsername("service");
            user.setUid(1);
            user.setLoginIp("ip");
            userService.loginLogReg(user);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
        }
    }
    
}
