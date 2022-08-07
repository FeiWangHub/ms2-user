package com.fei.chapter2user.dao;

import com.fei.chapter2user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {

    UserInfo selectByMobileNo(String mobikeNo);

    int insert(UserInfo userInfo);

    int updateById(UserInfo userInfo);
}

