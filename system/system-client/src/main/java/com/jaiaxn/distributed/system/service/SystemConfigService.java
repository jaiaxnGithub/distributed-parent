package com.jaiaxn.distributed.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.system.dto.req.*;
import com.jaiaxn.distributed.system.dto.resp.SystemConfigQueryResp;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
public interface SystemConfigService {

    /**
     * 新增系统配置参数
     *
     * @param req 系统配置参数
     * @return 新增结果
     */
    ResultVO<Boolean> insertSystemConfigParam(SystemConfigAddReq req);

    /**
     * 更新系统配置参数
     *
     * @param req 系统配置参数
     * @return 更新结果
     */
    ResultVO<Boolean> updateSystemConfigParam(SystemConfigUpdateReq req);

    /**
     * 删除系统配置参数
     *
     * @param req 系统配置参数
     * @return 删除结果
     */
    ResultVO<Boolean> deleteSystemConfigParam(SystemConfigDeleteReq req);

    /**
     * 查询系统配置参数
     *
     * @param req 查询参数
     * @return 查询结果
     */
    ResultVO<SystemConfigQueryResp> querySystemConfigParam(SystemConfigQueryReq req);

    /**
     * 查询所有系统配置参数
     *
     * @param req 查询参数
     * @return 查询结果
     */
    ResultVO<Page<SystemConfigQueryResp>> querySystemConfigParamByCondition(SystemConfigQueryForPageReq req);
}
