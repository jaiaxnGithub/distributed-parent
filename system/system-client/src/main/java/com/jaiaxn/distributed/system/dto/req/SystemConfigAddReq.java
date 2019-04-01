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
@ApiModel(value = "新增入参")
public class SystemConfigAddReq implements Serializable {

    private static final long serialVersionUID = 2066841006943697338L;

    //属性 begin
    /**
     * 属性ID
     */
    @ApiModelProperty(value = "属性ID")
    private String confId;

    /**
     * 属性值
     */
    @ApiModelProperty(value = "属性值")
    private String confValue;

}
