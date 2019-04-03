package com.jaiaxn.distributed.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月03日
 * @description: 定时任务调度启动类
 **/
@SpringBootApplication
@EnableJpaAuditing
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ElasticJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticJobApplication.class, args);
    }
}
