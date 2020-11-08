package com.netease.study.springboot.mybatis;

import com.netease.study.springboot.mybatis.repository.UsersDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UsersDao usersDao;

    @Test
    void contextLoads() {
        System.out.println(usersDao.findAll());
        System.out.println(usersDao.findById(1));
//        System.out.println(usersDao.findByName("%德%"));
        System.out.println(usersDao.findByName("德"));
    }

}
