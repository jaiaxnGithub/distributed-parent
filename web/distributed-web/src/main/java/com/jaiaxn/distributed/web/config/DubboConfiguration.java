package com.jaiaxn.distributed.web.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description: 消费者配置
 **/
@Configuration
public class DubboConfiguration {

    /**
     * 消费者配置不主动监督zookeeper服务
     *
     * @return 消费者配置信息
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);
        consumerConfig.setTimeout(5000);
        //不重发请求
        consumerConfig.setRetries(0);
        return consumerConfig;
    }
}
