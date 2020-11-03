package com.netease.study.springboot.web.demo.controller;

import com.netease.study.springboot.web.demo.entity.User;
import com.netease.study.springboot.web.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public String test(){
        return "login";
    }

    @RequestMapping("/user/login")
    public String login(String username, String password, ModelMap modelMap, HttpSession session){
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)
                && "admin".equals(username) && "admin".equals(password)){
            session.setAttribute("username",username);
            return "redirect:/user/list";
        }else{
            modelMap.addAttribute("login_error","用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("/user/list")
    public String list(ModelMap modelMap){
        List<User> list = userRepository.findAll();
        modelMap.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/user/delete")
    public String deleteById(int id){
        userRepository.deleteById(id);
        return "list";
    }
}
