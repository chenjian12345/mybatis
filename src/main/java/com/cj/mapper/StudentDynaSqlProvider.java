package com.cj.mapper;

import com.cj.pojo.Student;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @Description: TODO
 * @Author: chenj
 * @Date: 2020/11/5
 **/
public class StudentDynaSqlProvider {

    public String findAll() {
        return new SQL(){
            {
                SELECT("*");
                FROM("t_student");
            }
        }.toString();
    }
}
