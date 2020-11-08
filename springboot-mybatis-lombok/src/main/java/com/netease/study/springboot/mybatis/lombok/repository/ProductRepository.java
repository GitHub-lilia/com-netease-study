package com.netease.study.springboot.mybatis.lombok.repository;

import com.netease.study.springboot.mybatis.lombok.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductRepository {
    @Select("select * from product where uid=(select id from users where username=#{username})")
    List<Product> findProductByUsername(String username);

    @Select("select * from product where uid=#{uid}")
    List<Product> findProductByUid(int uid);

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select * from Product where id=#{id}")
    Product findById(int id);

    @Update("update product set name=#{product.name},description=#{product.description},price=#{product.price},pic=#{product.pic} where id=#{product.id}")
    void updateProduct(@Param("product") Product product);
}
