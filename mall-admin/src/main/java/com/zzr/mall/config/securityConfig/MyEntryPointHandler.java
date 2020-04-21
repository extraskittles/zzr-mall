package com.zzr.mall.config.securityConfig;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//未登录而访问受保护资源的处理
@Component
public class MyEntryPointHandler implements AuthenticationEntryPoint {
    private final String loginStr="/login.html";
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+loginStr);
    }
}
