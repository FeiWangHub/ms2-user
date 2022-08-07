package com.fei.chapter2user.controller;

import com.fei.chapter2user.entity.*;
import com.fei.chapter2user.entity.enums.ResultCode;
import com.fei.chapter2user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author joe
 */
@RestController
@RequestMapping("/c2user")
public class UserController {

    @Resource
    UserService userServiceImpl;

    @RequestMapping(value = "getSmsCode", method = RequestMethod.POST)
    public Boolean getSmsCode(@RequestParam("reqId") String reqId,
                              @RequestParam("mobileNo") String mobileNo) {
        GetSmsCodeReqVo getSmsCodeReqVo = GetSmsCodeReqVo.builder().reqId(reqId).mobileNo(mobileNo).build();
        boolean result = userServiceImpl.getSmsCode(getSmsCodeReqVo);
        return result;
    }

    @RequestMapping(value = "loginByMobile", method = RequestMethod.POST)
    public ApiResponse loginByMobile(@RequestParam("reqId") String reqId,
                                     @RequestParam("mobileNo") String mobileNo, @RequestParam("smsCode") String smsCode) throws BizException {
        LoginByMobileReqVo loginByMobileReqVo = LoginByMobileReqVo.builder().reqId(reqId).mobileNo(mobileNo)
                .smsCode(smsCode).build();
        LoginByMobileResVo loginByMobileResVo = userServiceImpl.loginByMobile(loginByMobileReqVo);
        return ApiResponse.success(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), loginByMobileResVo);
    }

    @RequestMapping(value = "loginExit", method = RequestMethod.POST)
    public Boolean loginExit(@RequestParam("userId") String userId,
                             @RequestParam("accessToken") String accessToken) {
        LoginExitReqVo loginExitReqVo = LoginExitReqVo.builder().userId(userId).accessToken(accessToken).build();
        boolean result = userServiceImpl.loginExit(loginExitReqVo);
        return result;
    }
}
