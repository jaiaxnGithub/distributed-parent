package com.jaiaxn.distributed.elastic.job.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import com.jaiaxn.distributed.system.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月03日
 * @description: 定时删除系统默认失效参数
 **/
@Slf4j
@Component
@ElasticSimpleJob(cron = "0/15 * * * * ?",
        jobName = "systemConfigDeleteJob",
        shardingTotalCount = 1,
        jobParameter = "测试参数",
        shardingItemParameters = "0=A,1=B",
        dataSource = "datasource")
public class SystemConfigDeleteJob implements SimpleJob {

    @Reference
    private SystemConfigService systemConfigService;

    @Override
    public void execute(ShardingContext shardingContext) {
        if (null == systemConfigService) {
            return ;
        }
        long startTime = System.currentTimeMillis();
        log.info("SystemConfigDeleteJob start-->startTime={}", startTime);

        //删除失效系统参数
        systemConfigService.deleteSystemConfigParamInvalid();

        long endTime = System.currentTimeMillis();
        log.info("SystemConfigDeleteJob end-->endTime={}",endTime);
    }
}