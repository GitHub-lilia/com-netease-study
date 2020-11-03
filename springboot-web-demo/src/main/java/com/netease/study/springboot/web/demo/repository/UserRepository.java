package com.netease.study.springboot.web.demo.repository;

import com.netease.study.springboot.web.demo.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    int deleteById(int id);
}
