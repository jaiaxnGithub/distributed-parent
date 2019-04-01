package com.jaiaxn.distributed.system.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Data
@ApiModel(value = "删除入参")
public class SystemConfigDeleteReq implements Serializable {

    private static final long serialVersionUID = -216200658671912200L;

    //属性 begin
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
}
