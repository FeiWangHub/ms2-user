package com.fei.chapter2user.dao;

import com.fei.chapter2user.entity.UserSmsCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSmsCodeDao {

    int insert(UserSmsCode userSmsCode);

    UserSmsCode selectByMobileNo(String mobileNo);
}
