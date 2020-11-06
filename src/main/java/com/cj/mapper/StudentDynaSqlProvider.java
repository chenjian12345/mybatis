package com.cj.mapper;

import org.apache.ibatis.jdbc.SQL;

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
