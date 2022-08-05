package com.fei.dao;

import com.fei.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    String TABLE_NAME = " user ";
    String ALL_FIELDS = "username,password";

    @Insert("INSERT INTO " + TABLE_NAME + "(" + ALL_FIELDS + ") VALUES (#{username}, #{password})")
    int addUser(User user);

}