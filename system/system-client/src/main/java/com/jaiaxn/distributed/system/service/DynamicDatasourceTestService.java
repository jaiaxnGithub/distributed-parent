package com.jaiaxn.distributed.system.service;

import com.jaiaxn.distributed.commom.dto.ResultVO;

import java.util.List;

/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description: 动态数据源测试
 **/
public interface DynamicDatasourceTestService {

    /**
     * 查询List测试
     *
     * @return 数据列表
     */
    ResultVO<List> queryListTest();
}
