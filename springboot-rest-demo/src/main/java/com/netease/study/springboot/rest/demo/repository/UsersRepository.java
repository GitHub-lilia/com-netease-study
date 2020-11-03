package com.netease.study.springboot.rest.demo.repository;

import com.netease.study.springboot.rest.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
