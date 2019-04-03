package com.jaiaxn.distributed.elastic.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月03日
 * @description: 数据源配置
 **/
@Configuration
public class DataSourceConfig {

    @Bean("datasource")
    @ConfigurationProperties("spring.datasource.druid.log")
    public DataSource dataSourceTow() {
        return DruidDataSourceBuilder.create().build();
    }
}
