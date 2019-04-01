package com.jaiaxn.distributed.commom.constant;

import com.jaiaxn.distributed.commom.dto.ResultCode;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
public enum ResultCodeEnum implements ResultCode {
    /**
     * SUCCESS
     */
    SUCCESS("0", "SUCCESS"),
    /**
     * ERROR
     */
    ERROR("-1", "ERROR"),

    /**
     * 用户未登录
     */
    NOT_LOGIN("100", "用户未登录"),
    /**
     * 服务器内部错误
     */
    SYSTEM_ERROR("500", "服务器内部错误");

    private final String code;
    private final String desc;

    private ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}