package com.netease.study.springboot.rest.demo.repository;

import com.netease.study.springboot.rest.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SpringDataRestUsersRepository extends JpaRepository<Users,Integer> {
    //支持的操作：
    //1. http://localhost:8080/userses
    //2. http://localhost:8080/userses?page=0&size=2
    //3. http://localhost:8080/userses?page=0&size=2&sort=id,asc
    //4. http://localhost:8080/userses/2

    //除了ID之外的查找，需要手动书写
    //1. http://localhost:8080/userses/search/findByUsername?username=zhangsan
    Users findByUsername(@Param("username") String username);

    //POST、PUT请求
    //http://localhost:8080/userses
    //{
    //    "username":"zhangsanfeng",
    //    "password":"123",
    //    "name":"张三丰"
    //}

    //PATCH请求，只更新部分字段
}
