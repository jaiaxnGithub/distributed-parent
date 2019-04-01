package com.jaiaxn.distributed.web.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.system.dto.req.*;
import com.jaiaxn.distributed.system.dto.resp.SystemConfigQueryResp;
import com.jaiaxn.distributed.system.service.SystemConfigService;
import com.jaiaxn.distributed.web.controller.system.req.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description:
 **/
@RestController
@RequestMapping("/api/systemConfig")
@Slf4j
@Api(value="系统默认参数相关接口:", tags={"系统默认参数相关接口"})
public class SystemConfigController {
    @Reference
    private SystemConfigService systemConfigService;

    @ApiOperation(value = "新增系统参数", notes = "新增系统参数")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/addSystemConfigParam", method = RequestMethod.POST)
    public ResultVO<Boolean> addSystemConfigParam(@RequestBody @ApiParam(value = "新增系统参数入参", required = true) @Valid ControllerSystemConfigAddReq req) {
        SystemConfigAddReq serverReq = new SystemConfigAddReq();
        BeanUtils.copyProperties(req, serverReq);
        return systemConfigService.insertSystemConfigParam(serverReq);
    }

    @ApiOperation(value = "更新系统参数", notes = "更新系统参数")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/updateSystemConfigParam", method = RequestMethod.POST)
    public ResultVO<Boolean> updateSystemConfigParam(@RequestBody @ApiParam(value = "更新系统参数入参", required = true) @Valid ControllerSystemConfigUpdateReq req) {
        SystemConfigUpdateReq serverReq = new SystemConfigUpdateReq();
        BeanUtils.copyProperties(req, serverReq);
        return systemConfigService.updateSystemConfigParam(serverReq);
    }

    @ApiOperation(value = "删除系统参数", notes = "删除系统参数")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/deleteSystemConfigParam", method = RequestMethod.POST)
    public ResultVO<Boolean> deleteSystemConfigParam(@RequestBody @ApiParam(value = "删除系统参数入参", required = true) @Valid ControllerSystemConfigDeleteReq req) {
        SystemConfigDeleteReq serverReq = new SystemConfigDeleteReq();
        BeanUtils.copyProperties(req, serverReq);
        return systemConfigService.deleteSystemConfigParam(serverReq);
    }

    @ApiOperation(value = "查询系统参数", notes = "查询系统参数")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/querySystemConfigParam", method = RequestMethod.POST)
    public ResultVO<SystemConfigQueryResp> addSystemConfigParam(@RequestBody @ApiParam(value = "查询系统参数入参", required = true) @Valid ControllerSystemConfigQueryReq req) {
        SystemConfigQueryReq serverReq = new SystemConfigQueryReq();
        BeanUtils.copyProperties(req, serverReq);
        return systemConfigService.querySystemConfigParam(serverReq);
    }

    @ApiOperation(value = "分页查询系统参数", notes = "分页查询系统参数")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/querySystemConfigParamForPage", method = RequestMethod.POST)
    public ResultVO<Page<SystemConfigQueryResp>> querySystemConfigParamForPage(@RequestBody @ApiParam(value = "分页查询系统参数入参", required = true) @Valid ControllerSystemConfigQueryForPageReq req) {
        SystemConfigQueryForPageReq serverReq = new SystemConfigQueryForPageReq();
        BeanUtils.copyProperties(req, serverReq);
        return systemConfigService.querySystemConfigParamByCondition(serverReq);
    }
}