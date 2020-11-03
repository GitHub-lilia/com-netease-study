package com.netease.study.springboot.rest.demo.controller;

import com.netease.study.springboot.rest.demo.entity.Users;
import com.netease.study.springboot.rest.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "users",method = RequestMethod.GET)
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.GET)
    public Users findById(@PathVariable int id){
        return usersRepository.findById(id).get();
    }

    @RequestMapping(value = "users",method = RequestMethod.POST)
    public Users saveUsers(@ModelAttribute Users users){
        return usersRepository.save(users);
    }

    @RequestMapping(value = "users",method = RequestMethod.PUT)
    public Users updateUsers(@ModelAttribute Users users){
        return usersRepository.saveAndFlush(users);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        usersRepository.deleteById(id);
    }
}
