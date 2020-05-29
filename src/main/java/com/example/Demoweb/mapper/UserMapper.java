package com.example.Demoweb.mapper;

import java.util.List;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.entity.UserLoginLog;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {
    
    /**
     * 插入用户数据到user表
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);
    
    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findByUsername(String username);
    
    /**
     * 插入用户登录数据到loginLog表
     * @param userLoginLog 用户登录数据
     * @return 受影响的行数
     */
    Integer insertLogin(User user);
    
   /**
    * 根据用户uid查询用户登录数据
    * @param uid
    * @return 匹配的用户登录数据，如果没有匹配的数据，则返回null
    */
    List<User> findByUid(Integer uid);
    
}
