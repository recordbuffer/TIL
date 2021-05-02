package com.mvc.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.board.model.biz.BoardBiz;
import com.mvc.board.model.dto.BoardDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private BoardBiz biz;
	
	
	@RequestMapping("/list.do")
	public String main(Model model) {
		logger.info("MAIN PAGE");
		
		model.addAttribute("list",biz.selectList());
		
		return "main";
	}
	

	@RequestMapping("/one.do")
	public String one(Model model, int bd_no) {
		logger.info("SELECT ONE");
		
		model.addAttribute("dto",biz.selectOne(bd_no));
		
		return "selectone";
	}
	
	
	@RequestMapping("/insert.do")
	public String insert() {
		logger.info("INSERT PAGE");
		
		return "insert";
	}
	
	
	@RequestMapping("/bdinsert.do")
	public String insertBoard(BoardDto dto) {
		logger.info("INSERT");
		
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
		} else {
		return "redirect:insert.do";		//redirect를 통해 요청을 리턴해줄 수 있음 
		}
	}
	
	
	
	@RequestMapping("/update.do")
	public String update(Model model, int bd_no) {
		logger.info("UPDATE PAGE");
		
		model.addAttribute("dto",biz.selectOne(bd_no));
		
		return "update";
	}
	
	@RequestMapping("/bdupdate.do")
	public String updateBoard(BoardDto dto) {
		logger.info("UPDATE");
		
		int res = biz.update(dto);
		if(res>0) {
			return "redirect:one.do?bd_no="+dto.getBd_no();
		} else {
			return "redirect:update.do?bd_no="+dto.getBd_no();
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
