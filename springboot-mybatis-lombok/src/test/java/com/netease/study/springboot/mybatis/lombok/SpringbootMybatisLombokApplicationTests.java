package com.netease.study.springboot.mybatis.lombok;

import com.netease.study.springboot.mybatis.lombok.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootMybatisLombokApplicationTests {

    @Resource
    private UsersRepository usersRepository;

    @Test
    void contextLoads() {
        System.out.println(usersRepository.findUsersById(1001));
    }

}
