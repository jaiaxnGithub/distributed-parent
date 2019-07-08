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
    NOT_LOGIN("100", "请稍登录后再进行操作"),

    /**
     * 用户未登录
     */
    NO_PERMISSION("101", "当前用户没有此操作权限");

    private final String code;
    private final String desc;

    ResultCodeEnum(String code, String desc) {
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