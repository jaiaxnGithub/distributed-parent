package com.jaiaxn.distributed.system.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.jaiaxn.distributed.system.common.SystemCommon;
import com.jaiaxn.distributed.system.dto.SystemConfigDTO;
import com.jaiaxn.distributed.system.dto.req.SystemConfigQueryForPageReq;
import com.jaiaxn.distributed.system.dto.resp.SystemConfigQueryResp;
import com.jaiaxn.distributed.system.entity.SystemConfig;
import com.jaiaxn.distributed.system.mapper.SystemConfigMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Component
public class SystemConfigManager {

    @Resource
    private SystemConfigMapper systemConfigMapper;

    public int insertSystemConfigParam(SystemConfigDTO reqDTO) {
        SystemConfig systemConfig = new SystemConfig();
        BeanUtils.copyProperties(reqDTO, systemConfig);
        systemConfig.setConfStatus(SystemCommon.systemStatus.VALID.getCode());
        return systemConfigMapper.insert(systemConfig);
    }

    public int updateSystemConfigParam(SystemConfigDTO reqDTO) {
        UpdateWrapper<SystemConfig> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(SystemConfig.FieldNames.id.getTableFieldName(), reqDTO.getId());
        SystemConfig systemConfig = new SystemConfig();
        BeanUtils.copyProperties(reqDTO, systemConfig);
        return systemConfigMapper.update(systemConfig, updateWrapper);
    }

    public int deleteSystemConfigParam(SystemConfigDTO reqDTO) {
        return systemConfigMapper.deleteById(reqDTO.getId());
    }

    public SystemConfigDTO querySystemConfigParam(SystemConfigDTO reqDTO) {
        SystemConfigDTO respDTO = new SystemConfigDTO();
        QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SystemConfig.FieldNames.confId.getTableFieldName(), reqDTO.getConfId());
        queryWrapper.eq(SystemConfig.FieldNames.confStatus.getTableFieldName(), reqDTO.getConfStatus());
        SystemConfig systemConfig = systemConfigMapper.selectOne(queryWrapper);
        BeanUtils.copyProperties(systemConfig, respDTO);
        return respDTO;
    }

    public Page<SystemConfigQueryResp> querySystemConfigParamByCondition(SystemConfigQueryForPageReq req) {
        Page<SystemConfigQueryResp> page = new Page<>(req.getPageNo(), req.getPageSize());
        return systemConfigMapper.querySystemConfigParamByCondition(page, req);
    }

    public void deleteSystemConfigParamInvalid(){
        QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SystemConfig.FieldNames.confStatus.getTableFieldName(), SystemCommon.systemStatus.INVALID.getCode());
        List<SystemConfig> systemConfigList = systemConfigMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(systemConfigList)) {
            List<String> idList = Lists.newArrayList();
            systemConfigList.forEach(item -> idList.add(item.getId()));
            QueryWrapper<SystemConfig> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.in(SystemConfig.FieldNames.id.getTableFieldName(),idList);
            systemConfigMapper.delete(deleteWrapper);
        }
    }
}
