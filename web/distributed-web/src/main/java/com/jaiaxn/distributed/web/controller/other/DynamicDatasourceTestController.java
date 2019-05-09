package com.jaiaxn.distributed.web.controller.other;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.system.service.DynamicDatasourceTestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description:
 **/
@RestController
@RequestMapping("/api/dynamicDatasourceTest")
@Slf4j
@Api(value="动态数据源测试相关接口:", tags={"动态数据源测试相关接口"})
public class DynamicDatasourceTestController {

    @Reference
    private DynamicDatasourceTestService dynamicDatasourceTestService;

    @ApiOperation(value = "动态数据源查询测试", notes = "动态数据源查询测试")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/queryListTest", method = RequestMethod.POST)
    public ResultVO<List> addSystemConfigParam() {
        return dynamicDatasourceTestService.queryListTest();
    }
}
