package com.jaiaxn.distributed.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@SpringBootApplication
@Slf4j
@EnableCaching
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DistributedWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DistributedWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        log.info("start--SpringBoot---web");
        return builder.sources(DistributedWebApplication.class);
    }
}
