package com.mvc.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.board.model.biz.MemberBiz;
import com.mvc.board.model.dto.MemberDto;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@Autowired
	private MemberBiz biz;
	
	
	@RequestMapping("/login.do")
	public String login() {
		logger.info("LOGIN PAGE");
		
		return "login";
	}

	@RequestMapping(value="/userlogin.do", method=RequestMethod.POST)
	public String userLogin(MemberDto dto, HttpServletRequest request) {
		logger.info("LOGIN");
		
		//세션 생성
		HttpSession session = request.getSession();
		System.out.println("세션 아이디: "+session.getId());
		
		//세션 유효시간
		session.setMaxInactiveInterval(3600);
		System.out.println("세션 유효시간:"+session.getMaxInactiveInterval());
		MemberDto res = biz.login(dto);
		
		if(res!=null) {
			
			//세션 저장
			session.setAttribute("res", res);
			return "redirect:list.do";
		} else {
			return "redirect:login.do";
		}
	}
	
	//로그아웃
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("LOGOUT");
		
		biz.logout(session);
		
		return "redirect:login.do";
	}

}
