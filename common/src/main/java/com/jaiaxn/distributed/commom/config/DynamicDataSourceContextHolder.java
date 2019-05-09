package com.jaiaxn.distributed.commom.config;

/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description: 动态数据源Context
 **/
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
