package com.sev.dao;

import java.sql.Connection;
import java.util.List;

import com.sev.dto.SEVBoardDto;

public interface SEVBoardDao {
	
	String selectAllsql = " SELECT * FROM SEVBOARD ";
	String selectOnesql = " SELECT * FROM SEVBOARD WHERE BD_NO=? ";
	
	//게시글 전체 출력
	public List<SEVBoardDto> selectAll(Connection con);
	//게시글 하나 출력
	public SEVBoardDto selectOne(Connection con, int bd_no);
	//글쓰기
	public boolean insert(Connection con, SEVBoardDto dto);
	//글수정
	public boolean update(Connection con, SEVBoardDto dto);
	//글삭제
	public boolean delete(Connection con, int bd_no);
	
}
