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

    private List<Student> studentList;

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

    public List<Student> getStudentList()
    {
        return studentList;
    }

    public void setStudentList(List<Student> studentList)
    {
        this.studentList = studentList;
    }

    @Override
    public String toString()
    {
        return "Class{" + "classId='" + classId + '\'' + ", className='" + className + '\'' + ", active=" + active
                + ", studentList=" + studentList + '}';
    }
}
