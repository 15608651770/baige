package com.example.Demoweb.entity;

import java.io.Serializable;

/**
 * 用户数据的实体类
 */
public class User extends BaseEntity implements Serializable {

    
    private Integer uid;
    private String username;
    private String password;
    private String cellphone;
    private String email;
    private String salt;
    private Integer state;
    
    private Integer loginId;
    private String loginIp;
    
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
        User other = (User) obj;
        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;
        return true;
    }
    public Integer getLoginId() {
        return loginId;
    }
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }
    public String getLoginIp() {
        return loginIp;
    }
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
    @Override
    public String toString() {
        return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", cellphone=" + cellphone
                + ", email=" + email + ", salt=" + salt + ", state=" + state + ", loginId=" + loginId + ", loginIp="
                + loginIp + "]";
    }
    
    
  
}
