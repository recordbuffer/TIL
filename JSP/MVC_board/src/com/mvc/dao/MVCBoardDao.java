package com.mvc.dao;

import static com.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDao {
	
	//게시글 전체 출력
	public List<MVCBoardDto> selectAll(){
		//db연결
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MVCBoardDto> res = new ArrayList<MVCBoardDto>();
		
		//쿼리 실행 준비
		String sql = " SELECT * FROM MVCBOARD ";
		
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
			close(rs);
			close(stmt);
			close(con);
		}
		
		return res;
	}
	
	//게시글하나 출력
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
	//글 여러개 삭제 (멀티삭제)
	public int multiDelete(String[] bd_no) {
		return 0;
	}
}
