package com.jaiaxn.distributed.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.system.dto.SystemConfigDTO;
import com.jaiaxn.distributed.system.dto.req.*;
import com.jaiaxn.distributed.system.dto.resp.SystemConfigQueryResp;
import com.jaiaxn.distributed.system.manager.SystemConfigManager;
import com.jaiaxn.distributed.system.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Slf4j
@Component("systemConfigService")
@Service(parameters = {"deleteSystemConfigParamInvalid.timeout","10000"})
public class SystemConfigServiceImpl implements SystemConfigService {

    private final SystemConfigManager systemConfigManager;

    @Autowired
    public SystemConfigServiceImpl(SystemConfigManager systemConfigManager) {
        this.systemConfigManager = systemConfigManager;
    }

    @Override
    public ResultVO<Boolean> insertSystemConfigParam(SystemConfigAddReq req) {
        log.info("SystemConfigServiceImpl.insertSystemConfigParam req={}", JSON.toJSON(req));
        boolean insertFlag;
        SystemConfigDTO systemConfigDTO = new SystemConfigDTO();
        BeanUtils.copyProperties(req, systemConfigDTO);
        int respNum = systemConfigManager.insertSystemConfigParam(systemConfigDTO);
        insertFlag = respNum > 0;
        log.info("SystemConfigServiceImpl.insertSystemConfigParam resp={}", insertFlag);
        return ResultVO.success(insertFlag);
    }

    @Override
    public ResultVO<Boolean> updateSystemConfigParam(SystemConfigUpdateReq req) {
        log.info("SystemConfigServiceImpl.updateSystemConfigParam req={}", JSON.toJSON(req));
        boolean updateFlag;
        SystemConfigDTO systemConfigDTO = new SystemConfigDTO();
        BeanUtils.copyProperties(req, systemConfigDTO);
        int respNum = systemConfigManager.updateSystemConfigParam(systemConfigDTO);
        updateFlag = respNum > 0;
        log.info("SystemConfigServiceImpl.updateSystemConfigParam resp={}", updateFlag);
        return ResultVO.success(updateFlag);
    }

    @Override
    public ResultVO<Boolean> deleteSystemConfigParam(SystemConfigDeleteReq req) {
        log.info("SystemConfigServiceImpl.deleteSystemConfigParam req={}", JSON.toJSON(req));
        boolean deleteFlag;
        SystemConfigDTO systemConfigDTO = new SystemConfigDTO();
        systemConfigDTO.setId(req.getId());
        int respNum = systemConfigManager.deleteSystemConfigParam(systemConfigDTO);
        deleteFlag = respNum > 0;
        log.info("SystemConfigServiceImpl.deleteSystemConfigParam resp={}", deleteFlag);
        return ResultVO.success(deleteFlag);
    }

    @Override
    public ResultVO<SystemConfigQueryResp> querySystemConfigParam(SystemConfigQueryReq req) {
        log.info("SystemConfigServiceImpl.querySystemConfigParam req={}", JSON.toJSON(req));
        SystemConfigQueryResp resp = new SystemConfigQueryResp();
        SystemConfigDTO systemConfigDTO = new SystemConfigDTO();
        BeanUtils.copyProperties(req, systemConfigDTO);
        SystemConfigDTO respDTO = systemConfigManager.querySystemConfigParam(systemConfigDTO);
        if (null != respDTO) {
            BeanUtils.copyProperties(respDTO, resp);
        }
        log.info("SystemConfigServiceImpl.querySystemConfigParam resp={}", JSON.toJSON(resp));
        return ResultVO.success(resp);
    }

    @Override
    public ResultVO<Page<SystemConfigQueryResp>> querySystemConfigParamByCondition(SystemConfigQueryForPageReq req) {
        log.info("MemberGroupServiceImpl querySystemConfigParamByCondition req={} ", JSON.toJSONString(req));
        Page<SystemConfigQueryResp> page = systemConfigManager.querySystemConfigParamByCondition(req);
        log.info("MemberGroupServiceImpl querySystemConfigParamByCondition resp={} ", JSON.toJSONString(page.getRecords()));
        return ResultVO.success(page);
    }

    @Override
    public void deleteSystemConfigParamInvalid() {
        log.info("MemberGroupServiceImpl deleteSystemConfigParamInvalid start ----->>>");
        systemConfigManager.deleteSystemConfigParamInvalid();
        log.info("MemberGroupServiceImpl deleteSystemConfigParamInvalid end ----->>>");
    }
}