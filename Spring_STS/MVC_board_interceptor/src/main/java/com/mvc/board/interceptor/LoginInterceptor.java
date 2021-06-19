package com.mvc.board.interceptor;

import java.io.IOException;

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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
	

		//로그인 창으로 들어가는 요청인지, 로그인 요청인지, 로그인 상태(세션)인지 확인해서 
		if(request.getRequestURI().contains("/login.do") || request.getRequestURI().contains("/userlogin.do") || request.getSession().getAttribute("res")!=null) {
			
			//맞다면 true
			return true;
		}
		
		//로그인이 안되어 있다면
		if(request.getSession().getAttribute("res")==null) {
			
			//로그인하라고 보내버리고 false
			response.sendRedirect("login.do");
			return false;
		}
		
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
