package com.jaiaxn.distributed.commom.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description:
 **/
public class DynamicDataSourceResolver extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}