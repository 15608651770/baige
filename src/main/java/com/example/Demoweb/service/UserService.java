package com.example.Demoweb.service;

import java.util.List;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.entity.UserLoginLog;

/**
 * 处理用户数据的业务接口
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 客户端提交的用户数据
     */
    void reg(User user);
    
    /**
     * 用户登录
     * @param username
     * @param password
     */
    User login(String username, String password);
    
    /**
     * 登录信息注册
     * @param userLoginLog
     */
    void loginLogReg(User user);
    
    /**
     * 登录信息获取在index页面
     */
    List<User> showLoginLog(Integer uid);
    
    
}
