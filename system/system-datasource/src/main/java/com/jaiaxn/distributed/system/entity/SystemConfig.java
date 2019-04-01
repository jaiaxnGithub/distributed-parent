package com.jaiaxn.distributed.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("system_config")
@ApiModel(value = "对应模型system_config, 对应实体SystemConfig类")
public class SystemConfig implements Serializable {

    private static final long serialVersionUID = -5822398530316070855L;

    /**
     * 表名常量
     */
    public static final String TABLE_NAME = "system_config";

    //属性 begin
    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
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
    //属性 end

    /** 字段名称枚举. */
    public enum FieldNames {
        /**
         * 属性ID
         */
        id("id","ID"),

        /**
         * 属性ID
         */
        confId("confId","CONF_ID"),

        /**
         * 属性值
         */
        confValue("confValue","CONF_VALUE"),

        /**
         * 属性状态，00A可用、00X不可用
         */
        confStatus("confStatus","CONF_STATUS");

        private String fieldName;
        private String tableFieldName;
        FieldNames(String fieldName, String tableFieldName){
            this.fieldName = fieldName;
            this.tableFieldName = tableFieldName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public String getTableFieldName() {
            return tableFieldName;
        }
    }

}
