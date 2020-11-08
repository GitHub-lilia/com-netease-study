package com.netease.study.springboot.mybatis.lombok.repository;

import com.netease.study.springboot.mybatis.lombok.entity.Users;
import org.apache.ibatis.annotations.*;

public interface UsersRepository {
    @Select("select count(1) from users where username=#{user.username} and password=#{user.password}")
    Integer findUser(@Param("user") Users user);

    @Select("select * from users where id=#{id}")
    @Results({
        @Result(property = "products",column = "id",many = @Many(select = "com.netease.study.springboot.mybatis.lombok.repository.ProductRepository.findProductByUid"))
    })
    Users findUsersById(int id);
}
