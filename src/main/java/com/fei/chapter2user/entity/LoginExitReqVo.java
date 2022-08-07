package com.fei.chapter2user.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LoginExitReqVo implements Serializable {

    private String userId;
    private String accessToken;

}
