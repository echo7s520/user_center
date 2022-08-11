package com.xx.user_center.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaoY
 * @date 2022/8/11 10:23
 */
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -8369591966692371497L;

    private int code;

    private T data;

    private String message;

    private String description;

    public BaseResponse(int code, T data,String message) {
        this(code,data,"","");
    }

    public BaseResponse(int code, T data) {
        this(code,data,"","");
    }

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription());

    }

}
