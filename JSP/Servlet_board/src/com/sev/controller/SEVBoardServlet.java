package com.sev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sev.biz.SEVBoardBiz;
import com.sev.biz.SEVBoardBizImpl;
import com.sev.dto.SEVBoardDto;


@WebServlet("/SEVBoardServlet")
public class SEVBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//요청받을 변수 선언
		String command = request.getParameter("command");
		
		SEVBoardBiz biz = new SEVBoardBizImpl();
		
		//만약 요청이 main라면?
		if(command.equals("main")) {
			//biz의 selectAll 메소드 리턴값 받을 변수 선언
			List<SEVBoardDto> list = biz.selectAll();
			request.setAttribute("list", list);
			
			//main.jsp로 이동 forward 방식
			dispatch("main.jsp", request, response);
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//dispatcher -> forward 방식 
	//클라이언트 요청에 전송한 데이터 유지
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	
	
	
}
