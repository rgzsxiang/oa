package com.bwf.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//方法1：实现接口public class LoginInterceptor implements HandlerInterceptor{}
//方法2：继承抽象类：public class LoginInterceptor extends HandlerInterceptorAdapter{}
public class LoginInterceptor extends HandlerInterceptorAdapter{
	//返回值是true代表不拦，false代表拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("user")==null){
			//未登录，拦截
			System.out.println("未登录，被拦截");
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		System.out.println("已登录，放过");
		return true;
	}

}
