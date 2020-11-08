package com.netease.study.springboot.mybatis.lombok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.netease.study.springboot.mybatis.lombok.repository")
@SpringBootApplication
public class SpringbootMybatisLombokApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisLombokApplication.class, args);
    }

}
