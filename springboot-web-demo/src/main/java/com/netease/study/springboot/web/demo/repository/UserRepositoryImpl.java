package com.netease.study.springboot.web.demo.repository;

import com.netease.study.springboot.web.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static List<User> users = new ArrayList<>();
    static {
        Collections.addAll(users,new User(1001,"zhangsan","123456","张三","男"),
                new User(1002,"lisi","123456","李四","女"),
                new User(1003,"wangwu","123456","王五","男"),
                new User(1004,"zhaoliu","123456","赵柳","女"),
                new User(1005,"wangba","123456","网吧","男"));
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public int deleteById(int id) {
        int num = 0;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User u = iterator.next();
            if(u.getId() == id){
                iterator.remove();
                num = 1;
            }
        }
        return num;
    }
}
