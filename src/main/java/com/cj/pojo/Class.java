package com.cj.pojo;

import java.util.List;

/**
 * @Description: TODO
 * @Author: chenj
 * @Date: 2020/11/4
 **/
public class Class {

    private String classId;

    private String className;

    private Byte active;

    private List<User> userList;

    public String getClassId()
    {
        return classId;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public Byte getActive()
    {
        return active;
    }

    public void setActive(Byte active)
    {
        this.active = active;
    }

    public List<User> getUserList()
    {
        return userList;
    }

    public void setUserList(List<User> userList)
    {
        this.userList = userList;
    }

    @Override
    public String toString()
    {
        return "Class{" + "classId='" + classId + '\'' + ", className='" + className + '\'' + ", active=" + active
                + ", userList=\r\n" + userList + "}";
    }
}
