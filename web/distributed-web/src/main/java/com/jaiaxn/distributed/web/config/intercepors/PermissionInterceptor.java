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
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author: wang.jiaxin
 * @date: 2019年07月08日
 * @description: 请求权限校验
 **/
public class PermissionInterceptor implements HandlerInterceptor {

    private final IdentityHashMap<String, String> urlRoleMap = new IdentityHashMap<String, String>() {{
        // ROLE_USER
        put("/api/systemConfig/*", "ROLE_USER");

        // ROLE_ADMIN
        put("/api/dynamicDatasourceTest/*", "ROLE_ADMIN");
    }};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute(Constant.SESSION_KEY);
        // 获取请求路径
        String url = httpServletRequest.getRequestURI();
        // 判断权限
        for (Map.Entry<String, String> entry : urlRoleMap.entrySet()) {
            if (entry.getValue().equals(sessionUser.getRole())) {
                String key = entry.getKey();
                if (isMatch(url.toCharArray(), key.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        PrintWriter printWriter = httpServletResponse.getWriter();
        ResultVO<String> resultVO = ResultVO.noPermisiion();
        printWriter.write(JSON.toJSONString(resultVO));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean isMatch(char[] str, char[] pattern, int index) {

        if (pattern.length == index) {
            if (str.length == index) {
                return true;
            }
            if (str.length > pattern.length && str[index] == '/') {
                return true;
            }

            if (str.length > pattern.length && pattern[index - 1] == '*') {
                return true;
            }
            return false;
        }
        if (pattern[index] == '*'){
            while (str.length - 1 > index){
                if (isMatch(str, pattern, ++index)) {
                    return true;
                }
            }
        }
        if (str.length == index) {
            return false;
        }
        if (str[index] == pattern[index]) {
            return isMatch(str, pattern, ++index);
        }
        return false;
    }
}
