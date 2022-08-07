package com.xx.user_center.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录实体类
 * @author xiaoY
 * @date 2022/8/7 14:14
 *
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -477032318497944160L;

    private String userAccount;

    private String userPassword;

}
