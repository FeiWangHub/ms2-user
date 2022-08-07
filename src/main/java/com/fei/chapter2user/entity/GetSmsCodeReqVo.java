package com.fei.chapter2user.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GetSmsCodeReqVo implements Serializable {

    private String reqId;
    private String mobileNo;

}