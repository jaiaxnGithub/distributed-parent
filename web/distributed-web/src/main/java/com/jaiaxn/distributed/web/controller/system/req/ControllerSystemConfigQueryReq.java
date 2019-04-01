package com.jaiaxn.distributed.web.controller.system.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Data
@ApiModel(value = "查询入参")
public class ControllerSystemConfigQueryReq implements Serializable {

    private static final long serialVersionUID = -1091325564790261592L;

    //属性 begin
    /**
     * 属性ID
     */
    @ApiModelProperty(value = "属性ID")
    @NotEmpty(message = "属性ID不能为空")
    private String confId;

    /**
     * 属性状态，00A可用、00X不可用
     */
    @ApiModelProperty(value = "属性状态")
    @NotEmpty(message = "属性状态不能为空")
    private String confStatus;

}
