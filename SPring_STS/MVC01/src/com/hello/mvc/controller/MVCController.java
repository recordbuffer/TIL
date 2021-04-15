package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.mvc.model.Biz;

@Controller
public class MVCController {

	//biz(@Service) 호출 
	@Autowired
	private Biz biz;
	
	
	// hello.do 요청받아 controller에서 실행할 메서드 찾기
	@RequestMapping("/hello.do")
	public String sayHello(Model model) {
	
		//biz에서 리턴받은 값 model 객체에 담아 전달함
		model.addAttribute("value", biz.sayHello());
		biz.sayHello();
		
	return "/WEB-INF/views/hello.jsp";
	}
}
