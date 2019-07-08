package com.jaiaxn.distributed.commom.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: wang.jiaxin
 * @date: 2019年07月08日
 * @description:
 **/
@Data
@ApiModel(value = "sessionUser")
public class SessionUser {

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户权限，ROLE_USER、ROLE_ADMIN")
    private String role;
}