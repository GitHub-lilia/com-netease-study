package com.netease.study.springboot.mybatis.repository;

import com.netease.study.springboot.mybatis.entity.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersDao {
    List<Users> findAll();
    Users findById(Integer id);
//    //使用#时，要求参数拼装之后传入，建议第二种方式
//    @Select("select * from users where name like #{name}")
    @Select("select * from users where name like '%${name}%'")
    List<Users> findByName(String name);
}
