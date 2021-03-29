package com.lib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.LibDao;
import com.lib.dto.LibDto;

@WebServlet("/lib.do")
public class libServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//요청받을 변수 선언
		String command = request.getParameter("command");
		
		LibDao dao = new LibDao();
		
		//만약 요청이 list라면?
		if(command.equals("list")) {
			response.sendRedirect("liblist.jsp");
			
		//만약 요청이 listdb라면?
		} else if(command.equals("listdb")) {
			//혹시 데이터가 있다면 먼저 지워줌
			dao.delete();
			
			String[] SeoulLibList = request.getParameterValues("lib");
			
			List<LibDto> dtos = new ArrayList<LibDto>();
			
			for(int i=0; i<SeoulLibList.length; i++) {
				String[] tmp = SeoulLibList[i].split("/"); 
				LibDto dto = new LibDto(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),tmp[2],tmp[3],tmp[4],tmp[5]);

				dtos.add(dto);
			}
			
			int res = dao.insert(dtos);
		
			
			if(res==dtos.size()) {
				jsResponse("db 저장 성공",response);
				response.sendRedirect("browser.html");
			} else {
				jsResponse("db 저장 실패",response);
				response.sendRedirect("liblist.jsp");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	//alert 메서드
	private void jsResponse(String msg, HttpServletResponse response) throws IOException {
		String alert = "<script type='text/javascript'>"+
						"alert('"+msg+"');"+
						"</script>";
		PrintWriter out = response.getWriter();
		out.print(alert);
	}
}
