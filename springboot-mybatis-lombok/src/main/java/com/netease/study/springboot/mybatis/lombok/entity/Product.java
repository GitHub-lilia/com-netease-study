package com.netease.study.springboot.mybatis.lombok.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String pic;
    private int uid;
}
