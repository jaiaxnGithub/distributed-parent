package com.jaiaxn.distributed.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.system.SystemServiceApplication;
import com.jaiaxn.distributed.system.dto.req.*;
import com.jaiaxn.distributed.system.dto.resp.SystemConfigQueryResp;
import com.jaiaxn.distributed.system.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemServiceApplication.class)
public class SystemConfigServiceImplTest {

    @Autowired
    private SystemConfigService systemConfigService;

    @Test
    public void insertSystemConfigParam() {
        SystemConfigAddReq systemConfigAddReq = new SystemConfigAddReq();
        systemConfigAddReq.setConfId("TEST_CONFIG_PARAM_5");
        systemConfigAddReq.setConfValue("测试参数5");
        ResultVO<Boolean> resultVO = systemConfigService.insertSystemConfigParam(systemConfigAddReq);
        log.info("SystemConfigServiceImplTest.insertSystemConfigParam resp={}", JSON.toJSON(resultVO.getResultData()));
    }

    @Test
    public void updateSystemConfigParam() {
        SystemConfigUpdateReq systemConfigUpdateReq = new SystemConfigUpdateReq();
        systemConfigUpdateReq.setId("1112627517852946434");
        systemConfigUpdateReq.setConfValue("测试参数5");
        systemConfigUpdateReq.setConfStatus("00X");
        ResultVO<Boolean> resultVO = systemConfigService.updateSystemConfigParam(systemConfigUpdateReq);
        log.info("SystemConfigServiceImplTest.updateSystemConfigParam resp={}", JSON.toJSON(resultVO.getResultData()));
    }

    @Test
    public void deleteSystemConfigParam() {
        SystemConfigDeleteReq systemConfigDeleteReq = new SystemConfigDeleteReq();
        systemConfigDeleteReq.setId("1112627414924718081");
        ResultVO<Boolean> resultVO = systemConfigService.deleteSystemConfigParam(systemConfigDeleteReq);
        log.info("SystemConfigServiceImplTest.deleteSystemConfigParam resp={}", JSON.toJSON(resultVO.getResultData()));
    }

    @Test
    public void querySystemConfigParam() {
        SystemConfigQueryReq systemConfigQueryReq = new SystemConfigQueryReq();
        systemConfigQueryReq.setConfId("TEST_CONFIG_PARAM_1");
        systemConfigQueryReq.setConfStatus("00A");
        ResultVO<SystemConfigQueryResp> resultVO = systemConfigService.querySystemConfigParam(systemConfigQueryReq);
        log.info("SystemConfigServiceImplTest.querySystemConfigParam resp={}", JSON.toJSON(resultVO.getResultData()));
    }

    @Test
    public void querySystemConfigParamByCondition() {
        SystemConfigQueryForPageReq systemConfigQueryForPageReq = new SystemConfigQueryForPageReq();
        systemConfigQueryForPageReq.setPageNo(1);
        systemConfigQueryForPageReq.setPageSize(3);
        ResultVO<Page<SystemConfigQueryResp>> resultVO = systemConfigService.querySystemConfigParamByCondition(systemConfigQueryForPageReq);
        log.info("SystemConfigServiceImplTest.querySystemConfigParamByCondition resp={}", JSON.toJSON(resultVO.getResultData()));
    }
}
