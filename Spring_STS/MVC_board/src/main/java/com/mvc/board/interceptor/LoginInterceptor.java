package com.mvc.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	
	//Controller 요청 전에 실행됨	
	@Override																			//handler 정보
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
	
		
		return false;		//true면 controller로 넘어감
	}
	
	//Controller 실행 후 handler 후 view에 응답 전에 실행됨
	@Override																						//view로 응답할때 model과 view 정보
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		logger.info("interceptor postHandle");
	}
	
	//view 처리 끝난 후 실행됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("interceptor afterCompletion");
	}	
}
