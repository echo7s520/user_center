package com.xx.user_center.model.request;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户注册实体类
 * @author xiaoY
 * @date 2022/8/7 14:14
 */
@Data
public class UserRegisterRequest implements Serializable {


    private static final long serialVersionUID = 3448728526940570096L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
