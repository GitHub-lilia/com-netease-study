package com.netease.study.springboot.hello.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
//@ConfigurationProperties(prefix = "person1")
@PropertySource("classpath:person2.properties")//自定义配置文件位置，还需要配合@ConfigurationProperties或@Value
@ConfigurationProperties(prefix = "person2")
public class Person {
//    @Value("${person.name}")
    private String name;
//    @Value("${person.sex}")
    private String sex;
//    @Value("#{11*2}")
    private int age;
    private boolean isMarried;
    private String[] pets;

    private Friend friend;

    private List<Friend> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String[] getPets() {
        return pets;
    }

    public void setPets(String[] pets) {
        this.pets = pets;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", pets=" + Arrays.toString(pets) +
                ", friend=" + friend +
                ", friends=" + friends +
                '}';
    }
}
