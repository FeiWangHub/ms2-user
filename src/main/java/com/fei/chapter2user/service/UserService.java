package com.fei.chapter2user.service;

import com.fei.chapter2user.entity.*;

public interface UserService {

    //获取短信验证码
    boolean getSmsCode(GetSmsCodeReqVo getSmsCodeReqVo);

    //短信登录
    LoginByMobileResVo loginByMobile(LoginByMobileReqVo loginByMobileReqVo) throws BizException;

    //登录退出
    boolean loginExit(LoginExitReqVo loginExitReqVo);

}