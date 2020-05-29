package com.example.Demoweb.entity;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录数据的实体类
 */
public class UserLoginLog implements Serializable {
    
    private static final long serialVersionUID = 3571076820983391528L;
    
    private Integer loginId;
    private Integer uid;
    private Date loginTime;
    private String loginIp;
    
    public Integer getLoginId() {
        return loginId;
    }
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Date getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public String getLoginIp() {
        return loginIp;
    }
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserLoginLog other = (UserLoginLog) obj;
        if (loginId == null) {
            if (other.loginId != null)
                return false;
        } else if (!loginId.equals(other.loginId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "UserLoginLog [loginId=" + loginId + ", uid=" + uid + ", loginTime=" + loginTime + ", loginIp=" + loginIp
                + "]";
    }
    
   
    
}
