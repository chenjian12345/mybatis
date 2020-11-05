package com.cj.pojo;

/**
 * @Description: TODO
 * @Author: chenj
 * @Date: 2020/11/5
 **/
public class TeacherClass {

    private String teacherClassId;

    private String teacherId;

    private String classId;

    private Byte active;

    private Teacher teacher;

    private Class class1;

    public String getTeacherClassId()
    {
        return teacherClassId;
    }

    public void setTeacherClassId(String teacherClassId)
    {
        this.teacherClassId = teacherClassId;
    }

    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getClassId()
    {
        return classId;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    public Byte getActive()
    {
        return active;
    }

    public void setActive(Byte active)
    {
        this.active = active;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
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
        return "TeacherClass{" + "teacherClassId='" + teacherClassId + '\'' + ", teacherId='" + teacherId + '\''
                + ", classId='" + classId + '\'' + ", active=" + active + ", teacher=" + teacher + ", class1=" + class1
                + '}';
    }
}
