package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDao {
	Connection con = null;
	
	//생성자 등록 
	public MVCBoardDao() {
		//driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//게시글 전체 출력 -> 목록
	public List<MVCBoardDto> selectAll(){
		//db 계정 연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		List<MVCBoardDto> res = new ArrayList<MVCBoardDto>();
		
		String sql = " SELECT * FROM MVCBOARD ORDER BY SEQ DESC ";
		
		//sql 쿼리 실행
		try {
			stmt = con.createStatement();
			System.out.println("03. query 준비: "+sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	//게시글 하나 출력 
	public MVCBoardDto selectOne(int bd_no) {
		return null;
	}
	
	//글쓰기 
	public int insert(MVCBoardDto dto) {
		return 0;
	}
	
	//글 수정
	public int update(MVCBoardDto dto) {
		return 0;
	}
	
	//글 삭제
	public int delete(int bd_no) {
		return 0;
	}
	
	//글 여러개 삭제
	public int multiDelete(String[] bd_no) {
		return 0;
	}	
}
