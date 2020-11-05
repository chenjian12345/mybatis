package com.cj.mapper;

import com.cj.pojo.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassMapper {

    @Select("select * from t_class c")
    @Results({
            @Result(property = "classId", column = "class_id"),
            @Result(property = "className", column = "class_name"),
            @Result(property = "studentList", javaType = List.class, column = "class_id",
                    many = @Many(select = "com.cj.mapper.StudentMapper.findByClassId"))})
    List<Class> findAll();

    @Select("select * from t_class where class_id = #{classId}")
    Class findByClassId(String classId);

}
