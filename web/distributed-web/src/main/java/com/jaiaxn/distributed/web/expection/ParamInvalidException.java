package com.jaiaxn.distributed.web.expection;

import java.util.List;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description: 参数校验异常
 **/
public class ParamInvalidException extends Exception {
    private List<String> errors;
    private static final long serialVersionUID = -5663471228514948673L;

    public ParamInvalidException(String errMsg) {
        super(errMsg);
    }

    public ParamInvalidException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
