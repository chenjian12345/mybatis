package com.cj.mapper;

import com.cj.pojo.Class;
import com.cj.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from User")
    List<User> findAll();

    @Select("select * from User u where u.classId = #{classId}")
    List<User> findByClassId(String classId);

    @Select("select * from User where userId = #{userId}")
    @Results({
            @Result(property = "class1", column = "classId", javaType = Class.class, one = @One(select = "com.cj.mapper.ClassMapper.findByClassId"))})
    List<User> findByUserId(String userId);
}
