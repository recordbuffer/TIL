package com.mvc.dao;

import java.sql.Connection;
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
		return null;
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
