package com.jaiaxn.distributed.commom.config;

import com.google.common.collect.Maps;
import com.jaiaxn.distributed.commom.dto.CfgDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.Map;
import java.util.Properties;

/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description: 动态数据源管理
 **/
public class DynamicDataSourceManager {

    /**
     * 创建数据源
     *
     * @param cfgDataSource 数据源实体
     * @return BasicDataSource
     */
    public static BasicDataSource createDataSourcePool(CfgDataSource cfgDataSource) {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        Properties properties = new Properties();
        properties.setProperty("", "");
        simpleDriverDataSource.setConnectionProperties(properties);
        BasicDataSource basicDataSource = new BasicDataSource();
        try {
            basicDataSource.setDriverClassName(cfgDataSource.getDbDriverClassName());
            basicDataSource.setUrl(cfgDataSource.getDbUrl());
            basicDataSource.setUsername(cfgDataSource.getDbUserName());
            basicDataSource.setPassword(cfgDataSource.getDbPassword());
            //最大空闲连接
            basicDataSource.setMaxIdle(cfgDataSource.getMaxIdle());
            //最大连接数
            basicDataSource.setMaxTotal(cfgDataSource.getMaxActive());
            basicDataSource.setMaxWaitMillis(cfgDataSource.getConnectionTimeOut());
            //超时时间
            basicDataSource.setRemoveAbandonedTimeout(cfgDataSource.getRemoveAbandoneTimeout());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basicDataSource;
    }

    /**
     * 获取数据源
     * @param cfgDataSource 数据源实体
     * @return JdbcTemplate
     */
    public static JdbcTemplate getDataSourcePool(CfgDataSource cfgDataSource) {
        BasicDataSource basicDataSource = createDataSourcePool(cfgDataSource);
        return new JdbcTemplate(basicDataSource);
    }


    /**
     * 变更数据源
     * @param cfgDataSource 数据源实体
     * @return DynamicDataSourceResolver
     */
    public static DynamicDataSourceResolver changeDatasource(CfgDataSource cfgDataSource) {
        BasicDataSource basicDataSource = createDataSourcePool(cfgDataSource);
        DynamicDataSourceResolver resolver = new DynamicDataSourceResolver();
        Map<Object, Object> dataSources = Maps.newHashMap();
        dataSources.put(cfgDataSource.getDatasourceId(), basicDataSource);
        resolver.setDefaultTargetDataSource(basicDataSource);
        resolver.setTargetDataSources(dataSources);
        resolver.afterPropertiesSet();
        return resolver;
    }

}
