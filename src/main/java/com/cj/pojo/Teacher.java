package com.cj.pojo;

/**
 * @Description: TODO
 * @Author: chenj
 * @Date: 2020/11/5
 **/
public class Teacher {

    private String teacherId;

    private String teacherName;

    private String active;

    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getActive()
    {
        return active;
    }

    public void setActive(String active)
    {
        this.active = active;
    }

    @Override
    public String toString()
    {
        return "Teacher{" + "teacherId='" + teacherId + '\'' + ", teacherName='" + teacherName + '\'' + ", active='"
                + active + '\'' + '}';
    }
}
