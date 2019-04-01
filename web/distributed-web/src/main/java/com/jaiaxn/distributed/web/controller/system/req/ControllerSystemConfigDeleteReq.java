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
@ApiModel(value = "删除入参")
public class ControllerSystemConfigDeleteReq implements Serializable {

    private static final long serialVersionUID = -216200658671912200L;

    //属性 begin
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotEmpty(message = "ID不能为空")
    private String id;
}
