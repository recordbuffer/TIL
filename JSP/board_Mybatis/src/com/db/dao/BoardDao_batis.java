package com.db.dao;

import java.util.List;

import com.db.dto.BoardDto;

public class BoardDao_batis {
	
	//게시글 전체 출력 -> 목록
	public List<BoardDto> selectAll(){
		return null;
	}
	
	//게시글 선택 출력
	public BoardDto selectOne(int bd_no) {
		return null;
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
	
	//글 여러개 삭제
	public int multiDelete(String[] bd_no) {
		return 0;
	}

}
