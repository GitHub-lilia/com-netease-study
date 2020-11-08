package com.netease.study.springboot.mybatis.lombok.controller;

import com.netease.study.springboot.mybatis.lombok.entity.Product;
import com.netease.study.springboot.mybatis.lombok.entity.Users;
import com.netease.study.springboot.mybatis.lombok.repository.ProductRepository;
import com.netease.study.springboot.mybatis.lombok.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

//此处如果使用@RestController，login.html会作为文本返回
//猜测thymeleaf不能正确解析
@Controller
public class UsersController {

    @Resource
    private UsersRepository usersRepository;

    @Resource
    private ProductRepository productRepository;

    @RequestMapping("/user/login")
    public String login(ModelMap modelMap, Users users, HttpSession session){
        modelMap.addAttribute("username",users.getUsername());
        if(usersRepository.findUser(users)!=0){
            session.setAttribute("user",users);
            return "redirect:/user/list";
        }else{
            modelMap.addAttribute("login_error","用户名或密码错误！");
            return "login.html";
        }
    }

    @RequestMapping("/user/list")
    public String findProducts(ModelMap modelMap,HttpSession session){
        List<Product> products = productRepository.findProductByUsername(((Users) session.getAttribute("user")).getUsername());
        modelMap.addAttribute("list",products);
        return "list.html";
    }
}
