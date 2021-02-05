package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.dto.BoardDto;

public class BoardDao {
	Connection con = null;
	
	//생성자 등록 
	public BoardDao() {
		//driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//게시글 전체 출력 -> 목록
	public List<BoardDto> selectAll(){
		//db 계정 연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		List<BoardDto> res = new ArrayList<BoardDto>();
		
		String sql = " SELECT * FROM BOARD ";
		
		//sql 쿼리 실행
		try {
			stmt = con.createStatement();
			
			//쿼리 실행 결과 rs에 저장
			rs = stmt.executeQuery(sql);
			
			//rs dto에 순서대로 저장
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			
				res.add(dto);
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

	//게시글 선택 출력
	public BoardDto selectOne(int bd_no) {
		//db 계정 연결
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BoardDto res = null;
		
		String sql = " SELECT * FROM BOARD WHERE BD_NO=? ";
		
		//sql 쿼리 실행
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, bd_no);
			
			//쿼리 실행 결과  rs에 저장
			rs = pstm.executeQuery();
			
			//rs(선택한 번호의 데이터값) -> res에 하나씩 저장
			while(rs.next()) {
				res = new BoardDto();
				res.setBd_no(rs.getInt(1));
				res.setBd_name(rs.getString(2));
				res.setBd_title(rs.getString(3));
				res.setBd_content(rs.getString(4));
				res.setBd_date(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	//글 추가
	public int insert(BoardDto dto) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		return 0;
	}
	
	//글 수정
	public int update(BoardDto dto) {
		return 0;
	}
	
	//글 삭제
	public int delete(int bd_no) {
		return 0;
	}
}
