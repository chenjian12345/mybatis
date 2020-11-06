package com.cj.mapper;

import com.cj.pojo.Class;
import com.cj.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

//    @Select("select * from t_student")
//    @SelectProvider(type = StudentDynaSqlProvider.class, method = "findAll")
    List<Student> findAll();

    @Select("select * from t_student where class_id = #{classId}")
    List<Student> findByClassId(String classId);

    @Select("select * from t_student s where s.student_id = #{studentId}")
    @Results({
            @Result(column = "student_id", property = "studentId"),
            @Result(property = "class1", javaType = Class.class, column = "class_id",
                    one = @One(select = "com.cj.mapper.ClassMapper.findByClassId"))
    })
    List<Student> findByStudentId(String studentId);
}
