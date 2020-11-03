package com.netease.study.springboot.web.demo.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(null != request.getSession().getAttribute("username")){
            return true;
        }else{
            request.setAttribute("login_error","请先登录！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }
}
