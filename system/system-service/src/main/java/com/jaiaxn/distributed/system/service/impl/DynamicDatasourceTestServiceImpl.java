package com.jaiaxn.distributed.system.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jaiaxn.distributed.commom.dto.CfgDataSource;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.system.config.DynamicDatasourceService;
import com.jaiaxn.distributed.system.service.DynamicDatasourceTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description:
 **/
@Slf4j
@Component("dynamicDatasourceTestService")
@Service
public class DynamicDatasourceTestServiceImpl implements DynamicDatasourceTestService {

    private final DynamicDatasourceService dynamicDatasourceService;

    @Autowired
    public DynamicDatasourceTestServiceImpl(DynamicDatasourceService dynamicDatasourceService) {
        this.dynamicDatasourceService = dynamicDatasourceService;
    }

    @Override
    public ResultVO<List> queryListTest() {
        CfgDataSource dataSource = new CfgDataSource();
        dataSource.setDbUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=47.104.230.230)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=orcl.lan)))");
        dataSource.setDbUserName("shyw_soc");
        dataSource.setDbPassword("soc");
        dataSource.setMaxActive(100);
        dataSource.setConnectionTimeOut(100);
        dataSource.setMaxIdle(10);
        dataSource.setRemoveAbandoneTimeout(180);
        dataSource.setDbType("oracle");
        dataSource.setDbDriverClassName("oracle.jdbc.driver.OracleDriver");
        String sql = "SELECT US.STAFF_ID,US.STAFF_NAME FROM UOS_STAFF US";
        List<Map<String, Object>> list = dynamicDatasourceService.executeDynamicSqlForList(dataSource, sql, new ArrayList<>().toArray());
        return ResultVO.success(list);
    }
}
