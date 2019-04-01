package com.jaiaxn.distributed.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaiaxn.distributed.system.dto.req.SystemConfigQueryForPageReq;
import com.jaiaxn.distributed.system.dto.resp.SystemConfigQueryResp;
import com.jaiaxn.distributed.system.entity.SystemConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@Mapper
public interface SystemConfigMapper extends BaseMapper<SystemConfig> {

    /**
     * 分页查询系统配置参数
     * @param page 分页
     * @param req 查询参数
     * @return 查询结果
     */
    Page<SystemConfigQueryResp> querySystemConfigParamByCondition(Page<SystemConfigQueryResp> page, @Param("req") SystemConfigQueryForPageReq req);
}
