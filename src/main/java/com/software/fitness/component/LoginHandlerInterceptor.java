package com.software.fitness.component;
import com.software.fitness.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Autowired
//    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Staff user = (Staff) request.getSession().getAttribute("loginUser");
        if(null == user){
            request.setAttribute("message", "没有权限请先登录");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        }
            return true;
    }
}
