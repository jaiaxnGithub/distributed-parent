package com.jaiaxn.distributed.system.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.jaiaxn.distributed.system.interceptor.MysqlKeyGenerator;
import com.jaiaxn.distributed.system.interceptor.TelDbKeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Configuration
@MapperScan("com.jaiaxn.distributed.system.mapper.*")
public class MybatisPlusConfig {

    @Value("${db-type}")
    private String dbType;

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public IKeyGenerator getKeyGenerator(){
        if (DB_TYPE_TELDB.equalsIgnoreCase(dbType)) {
            return new TelDbKeyGenerator();
        } else if (DB_TYPE_ORACLE.equalsIgnoreCase(dbType)) {
            return new OracleKeyGenerator();
        }
        return new MysqlKeyGenerator();
    }

    public static final String DB_TYPE_MYSQL = "MySql";

    public static final String DB_TYPE_TELDB = "TelDB";

    public static final String DB_TYPE_ORACLE = "Oracle";
}
