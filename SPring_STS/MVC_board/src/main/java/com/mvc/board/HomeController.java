package com.mvc.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.board.model.biz.BoardBiz;
import com.mvc.board.model.dto.BoardDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private BoardBiz biz;
	
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		
		model.addAttribute("list",biz.selectList());
		
		return "main";
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("dto",biz.selectOne(myno));
		
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		logger.info("INSERT RES");
		
		int res = biz.insert(dto);
		if(res>0) {
			return "redirect:list.do";
		} else {
		return "redirect:insertform.do";		//redirect를 통해 요청을 리턴해줄 수 있음 
		}
	}
	
	@RequestMapping("/updateform.do")
	public String update(Model model, int myno) {
		logger.info("UPDATE FROM");
		
		model.addAttribute("dto",biz.selectOne(myno));
		
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {
		logger.info("UPDATE RES");
		
		int res = biz.update(dto);
		if(res>0) {
			return "redirect:detail.do?myno="+dto.getBd_no();
		} else {
			return "redirect:updateform.do?myno="+dto.getBd_no();
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		
		int res = biz.delete(myno);
		if(res>0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno="+myno;
		}
	}
	
	
}
