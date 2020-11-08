package com.netease.study.springboot.mybatis.lombok.controller;

import com.netease.study.springboot.mybatis.lombok.entity.Product;
import com.netease.study.springboot.mybatis.lombok.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ProductController {

    @Resource
    private ProductRepository productRepository;

    @ResponseBody
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
        return "success";
    }

    @ResponseBody
    @GetMapping("/product/{id}")
    public Object findProductById(@PathVariable int id){
        return productRepository.findById(id);
    }

    @RequestMapping("/product/update")
    public String updateProduct(Product product){
        productRepository.updateProduct(product);
        return "redirect:/user/list";
    }
}
