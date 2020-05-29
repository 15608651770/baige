package com.example.Demoweb.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.entity.UserLoginLog;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    
    @Autowired
    UserMapper userMapper;
    
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("project");
        user.setPassword("1234");
        user.setSalt("salt");
        user.setCellphone("13800138002");
        user.setEmail("project@163.com");
        user.setState(1);
        user.setCreatedUser("系统管理员");
        user.setCreatedTime(new Date());
        user.setModifiedUser("超级管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.insert(user);
        System.err.println("rows=" + rows);
        System.err.println(user);
    }
    
    @Test
    public void findByUsername() {
      String username = "project";
      User result = userMapper.findByUsername(username);
      System.err.println(result);
    }
    
    @Test
    public void insertLogin() {
        User user = new User();
        user.setUid(1);
        user.setLoginIp("ip");
        user.setCreatedUser("系统管理员");
        user.setCreatedTime(new Date());
        user.setModifiedUser("超级管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.insertLogin(user);
        System.err.println("rows=" + rows);
        System.err.println(user);
    }

    @Test
    public void findByUid() {
      Integer uid = 1;
      List<User> result = userMapper.findByUid(uid);
      for (User user: result) {
        System.err.println(user);
    }
    }
    
}
