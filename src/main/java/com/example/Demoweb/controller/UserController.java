package com.example.Demoweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.service.UserService;
import com.example.Demoweb.util.JsonResult;


/**
 * 用户功能控制器
 * 
 */
@RequestMapping("users")
@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    /**
     * 响应到客户端的、表示操作成功的状态值
     */
    private static final int OK = 2000;
    
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
      // 调用业务对象执行注册
      userService.reg(user);
      // 返回成功
      return new JsonResult<>(OK);
    }
    
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        System.out.println("UserController.login()");
        // 调用userService.login()方法执行登录，并获取返回结果（成功登录的用户数据）
        System.out.println("username:"+username+",password:"+password);
        User data = userService.login(username, password);
        // 将返回结果中的uid和username存入到Session
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        session.setAttribute("loginId", data.getLoginId());
        //
        System.out.println(data.getLoginId());
        session.setAttribute("modifiedTime", data.getModifiedTime());
        session.setAttribute("loginIp", data.getLoginIp());
        //执行登录信息注册
        userService.loginLogReg(data);
        // 将结果响应给客户端
        return new JsonResult<>(OK, data);
    }
    
    
    
    
}
