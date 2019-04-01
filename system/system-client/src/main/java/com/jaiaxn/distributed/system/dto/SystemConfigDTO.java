package com.jaiaxn.distributed.system.dto;

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
@ApiModel(value = "systemConfig DTO")
public class SystemConfigDTO implements Serializable {

    private static final long serialVersionUID = 5791328891302001649L;

    //属性 begin
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

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

    /**
     * 属性状态，00A可用、00X不可用
     */
    @ApiModelProperty(value = "属性状态")
    private String confStatus;

}
