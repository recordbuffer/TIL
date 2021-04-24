package com.mvc.board.Dao;

import java.util.List;

import com.mvc.board.Dto.BoardDto;

public interface BoardDao {

	String NAMESPACE = "myboard.";
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int bd_no);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int bd_no);
	
}
