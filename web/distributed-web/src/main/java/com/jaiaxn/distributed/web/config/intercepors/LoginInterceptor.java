package com.jaiaxn.distributed.web.config.intercepors;

import com.alibaba.fastjson.JSON;
import com.jaiaxn.distributed.commom.constant.Constant;
import com.jaiaxn.distributed.commom.dto.ResultVO;
import com.jaiaxn.distributed.commom.dto.SessionUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author: wang.jiaxin
 * @date: 2019年07月08日
 * @description: 登录校验
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute(Constant.SESSION_KEY);
        if (null != sessionUser) {
            PrintWriter printWriter = httpServletResponse.getWriter();
            ResultVO<String> resultVO = ResultVO.noLogin();
            printWriter.write(JSON.toJSONString(resultVO));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
