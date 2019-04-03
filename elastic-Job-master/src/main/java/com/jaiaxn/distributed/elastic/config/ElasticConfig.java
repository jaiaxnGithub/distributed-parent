package com.jaiaxn.distributed.elastic.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.jaiaxn.distributed.elastic.listener.ElasticJobListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月03日
 * @description:
 **/
@Configuration
@ConditionalOnExpression("'${elastic.zookeeper.server-lists}'.length() >0")
public class ElasticConfig {
    /**
     * 初始化配置
     *
     * @param serverList zk服务列表
     * @param namespace 命名空间
     * @return 初始化配置
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${elaticjob.zookeeper.server-lists}") String serverList
            , @Value("${elaticjob.zookeeper.namespace}") String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }

    /**
     * 设置活动监听，前提是已经设置好了监听，见下一个目录
     *
     * @return 活动监听
     */
    @Bean
    public ElasticJobListener elasticJobListener() {
        return new ElasticJobListener(100, 100);
    }

}