package com.cj.pojo;

/**
 * @Description: 用户实体类
 * @Author: chenj
 * @Date: 2020/10/19
 **/
public class User {
    private String userId;

    private String userName;

    private String password;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
