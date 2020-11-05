package com.cj.pojo;

/**
 * @Description: TODO
 * @Author: chenj
 * @Date: 2020/11/5
 **/
public class Student {

    private String studentId;

    private String studentName;

    private String classId;

    private Integer age;

    private Byte active;

    private Class class1;

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getClassId()
    {
        return classId;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Byte getActive()
    {
        return active;
    }

    public void setActive(Byte active)
    {
        this.active = active;
    }

    public Class getClass1()
    {
        return class1;
    }

    public void setClass1(Class class1)
    {
        this.class1 = class1;
    }

    @Override
    public String toString()
    {
        return "Student{" + "studentId='" + studentId + '\'' + ", studentName='" + studentName + '\'' + ", classId='"
                + classId + '\'' + ", age=" + age + ", active=" + active + ", class1=" + class1 + '}';
    }
}
