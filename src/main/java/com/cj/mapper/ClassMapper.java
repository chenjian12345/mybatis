package com.cj.mapper;

import com.cj.pojo.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassMapper {

    @Select("select c.*, c.classId classId1 from class c")
    @Results({
            @Result(property = "classId", column = "classId1"),
//            @Result(property = "className", column = "className"),
            @Result(property = "userList", javaType = List.class, column = "classId",
                    many = @Many(select = "com.cj.mapper.UserMapper.findByClassId"))})
    List<Class> findAll();

    @Select("select * from class where classId = #{classId}")
    Class findByClassId(String classId);

}
