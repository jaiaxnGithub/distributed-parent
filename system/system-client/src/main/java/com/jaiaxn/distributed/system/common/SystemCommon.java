package com.jaiaxn.distributed.system.common;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
public class SystemCommon {
    /**
     *  通用状态
     */
    public enum systemStatus {
        /**
         * 可用
         */
        VALID("00A","可用"),
        /**
         * 不可用
         */
        INVALID("00X","不可用");

        private String value;
        private String code;

        systemStatus(String code, String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }
    }
}
