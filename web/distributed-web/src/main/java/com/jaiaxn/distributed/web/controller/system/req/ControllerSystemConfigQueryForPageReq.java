package com.jaiaxn.distributed.web.controller.system.req;

import com.jaiaxn.distributed.commom.dto.PageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Data
@ApiModel(value = "分页查询入参")
public class ControllerSystemConfigQueryForPageReq extends PageVO {
    private static final long serialVersionUID = -7451718720262381102L;

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

    /**
     * 属性状态，00A可用、00X不可用
     */
    @ApiModelProperty(value = "属性状态")
    private String confStatus;

}
