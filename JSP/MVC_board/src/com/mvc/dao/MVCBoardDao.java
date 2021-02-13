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
			Class.forName("oacle.jdbc.driver.OracleDriver");
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
		
		String sql = " SELECT * FROM MVCBOARD ";
		
		//sql 쿼리 실행 
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MVCBoardDto tmp = new MVCBoardDto();
				tmp.setBd_no(rs.getInt(1));
				tmp.setBd_name(rs.getString(2));
				tmp.setBd_title(rs.getString(3));
				tmp.setBd_content(rs.getString(4));
				tmp.setBd_date(rs.getDate(5));
				
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
