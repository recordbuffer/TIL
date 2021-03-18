package com.sev.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
			
		//만약 요청이 one라면?
		} else if(command.equals("one")) {
			//같이 넘겨준 bd_no도 가져옴
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			SEVBoardDto dto = biz.selectOne(bd_no);
		
			request.setAttribute("dto", dto);
			dispatch("selectone.jsp", request, response);
		
		//만약 요청이 insert라면?
		} else if(command.equals("insert")) {
			response.sendRedirect("insert.jsp");
	
		//만약 요청이 bdinsert라면?
		} else if(command.equals("bdinsert")) {
			String name = request.getParameter("sevname");
			String title = request.getParameter("sevtitle");
			String content = request.getParameter("sevcontent");
			
			SEVBoardDto dto = new SEVBoardDto(name, title, content);
			boolean res = biz.insert(dto);
			if(res) {
				jsResponse("글 작성 성공", "controller.do?command=main", response);
			} else {
				
				dispatch("controller.do?command=insert", request, response);
			}
			
		//만약 요청이 update라면?
		} else if(command.equals("update")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			
			//게시글의 원래 데이터 값 대로 update.jsp로 보내줌
			SEVBoardDto dto = biz.selectOne(bd_no);
			
			request.setAttribute("dto", dto);
			dispatch("update.jsp", request, response);
		
		//만약 요청이 bdupdate라면?
		} else if(command.equals("bdupdate")) {
			int bd_no = Integer.parseInt(request.getParameter("bd_no"));
			String title = request.getParameter("sevtitle");
			String content = request.getParameter("sevcontent");
			
			SEVBoardDto dto = new SEVBoardDto(bd_no, title, content);
			boolean res = biz.update(dto);
			if(res) {
				jsResponse("글 수정 성공", "controller.do?command=one&bd_no="+bd_no, response);
			} else {
				dispatch("controller.do?command=update&bd_no="+bd_no, request, response);
			}
			
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
	
	//alert 메서드
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String alert = "<script type='text/javascript'>"+
						"alert('"+msg+"');"+
						"location.href='"+url+"';"+
						"</script>";
		PrintWriter out = response.getWriter();
		out.print(alert);
	}
	
	
	
}
