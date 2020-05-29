package com.example.Demoweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.service.UserService;
import com.example.Demoweb.util.JsonResult;

/**
 * 页面功能控制器
 * 
 */
@RequestMapping("main")
@RestController
public class MainController {
    /**
     * 响应到客户端的、表示操作成功的状态值
     */
    protected static final int OK = 2000;
    
    @Autowired
    UserService userService;

    @RequestMapping("index")
    public JsonResult<List<User>> showIndex(HttpSession session){
        //日志
        System.out.println("UserController.showIndex()");
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        List<User> data = userService.showLoginLog(uid);
        
        return new JsonResult<>(OK,data);
    }
}
