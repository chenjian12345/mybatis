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

    private Integer age;

    private String classId;

    private Class class1;

    private Byte active;

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

    public Byte getActive()
    {
        return active;
    }

    public void setActive(Byte active)
    {
        this.active = active;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Class getClass1()
    {
        return class1;
    }

    public void setClass1(Class class1)
    {
        this.class1 = class1;
    }

    public String getClassId()
    {
        return classId;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    @Override
    public String toString()
    {
        return "User{" + "userId='" + userId + '\'' + ", userName='" + userName + '\'' + ", password='" + password
                + '\'' + ", age=" + age + ", class1=" + class1 + ", active=" + active + '}';
    }
}
