package com.example.Demoweb.service.Impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demoweb.entity.User;
import com.example.Demoweb.entity.UserLoginLog;
import com.example.Demoweb.mapper.UserMapper;
import com.example.Demoweb.service.UserService;
import com.example.Demoweb.service.ex.InsertException;
import com.example.Demoweb.service.ex.PasswordNotMatchException;
import com.example.Demoweb.service.ex.UidNotFoundException;
import com.example.Demoweb.service.ex.UserNotFoundException;
import com.example.Demoweb.service.ex.UsernameDuplicateException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public void reg(User user) {
        // 日志
        System.err.println("UserServiceImpl.reg()");
        // 通过参数user获取尝试注册的用户名
        String username = user.getUsername();
        // 调用userMapper.findByUsername()方法执行查询
        User result = userMapper.findByUsername(username);
        // 判断查询结果是否不为null
        if (result != null) {
            // 是：查询到了数据，表示用户名已经被占用，则抛出UsernameDuplicationException
            throw new UsernameDuplicateException("用户名已经被占用");
        }

        // 如果代码能执行到这一行，则表示没有查到数据，表示用户名未被注册，则允许注册
        // 创建当前时间对象：
        Date now = new Date();
        // 向参数user中补全数据：salt, password，涉及加密处理.
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String md5Password = getMd5Password(user.getPassword(), salt);
        user.setPassword(md5Password);
        // 向参数user中补全数据：state(1)
        user.setState(1);
        // 向参数user中补全数据：4项日志(now, user.getUsername())
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        // 调用userMapper.insert()执行插入数据，并获取返回的受影响行数
        Integer rows = userMapper.insert(user);
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 是：插入数据失败，则抛出InsertException
            throw new InsertException("插入数据失败");
        }
    }

    /**
     * 执行密码加密，获取加密后的结果
     * 
     * @param password 原始密码
     * @param salt     盐值
     * @return 加密后的结果
     */
    private String getMd5Password(String password, String salt) {
        // 加密标准：使用salt+password+salt作为被运算数据，循环加密3次
        String result = salt + password + salt;
        for (int i = 0; i < 3; i++) {
            result = DigestUtils.md5Hex(result);
        }
        System.err.println("\tpassword=" + password);
        System.err.println("\tsalt=" + salt);
        System.err.println("\tmd5Password=" + result);
        return result;
    }

    @Override
    public User login(String username, String password) {
        // 日志
        System.err.println("UserServiceImpl.login()");
        // 基于参数username调用userMapper.findByUsername()查询用户数据
        User result = userMapper.findByUsername(username);
        System.out.println(result);
        // 判断查询结果(result)是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException("登录失败，用户名不存在！");
        }

        // 判断查询结果(result)中的state是否为0
        if (result.getState() == 0) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException("登录失败，用户数据已经被删除！");
        }
        // 从查询结果(result)中获取盐值
        String salt = result.getSalt();
        // 基于参数password和盐值，调用getMd5Password()执行加密
        String md5Password = getMd5Password(password, salt);
        // 判断查询结果(result)中的密码和以上加密结果是否不一致
        if (!md5Password.equals(result.getPassword())) {
            // 是：抛出PasswordNotMatchException
            throw new PasswordNotMatchException("登录失败，密码错误！");
        }
        // 创建新的User对象
        User user = new User();
        // 将查询结果中的uid、username设置到新的User对象的对应的属性中
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        // 返回新创建的User对象
        return user;
    }

    @Override
    public void loginLogReg(User user) {
        // 日志
        System.out.println("UserServiceImpl.loginLogReg()");
        String username = user.getUsername();
//        System.out.println("username:"+username);
//        User result = userMapper.findByUsername(username);
//        System.out.println(result);
        // 创建当前时间对象：
        Date now = new Date();
//        // 向参数user中补全数据：
//        System.out.println(result.getUid());
//        user.setUid(result.getUid());
        String loginIp = getIPAddress(request);
        System.out.println(loginIp);
        user.setLoginIp(loginIp);
        // 向参数user中补全数据：4项日志(now, user.getUsername())
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        System.out.println(user);
        // 调用userMapper.insertinsertLogin()执行插入数据，并获取返回的受影响行数
        Integer rows = userMapper.insertLogin(user);
        System.out.println(rows);
        if (rows != 1) {
            // 是：插入数据失败，则抛出InsertException
            throw new InsertException("插入数据失败");
        }

    }

    @Override
    public List<User> showLoginLog(Integer uid) {
        //日志
        System.out.println("UserServiceImpl.showLoginLog()");
        
        List<User> list = userMapper.findByUid(uid);
        //取出集合中最后一个元素，即最后一次登陆数据
        User result = list.get(list.size()-1);
        System.out.println(result.getLoginId());
        System.out.println(result);
     // 判断查询结果(result)是否为null
        if (result == null) {
            // 是：抛出UidNotFoundException
            throw new UidNotFoundException("查询失败，uid不存在！");
        }
            
        return list;
    }

    /**
     * 获取ip
     * 
     * @param request
     * @return
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("X-Real-IP");
        }
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
