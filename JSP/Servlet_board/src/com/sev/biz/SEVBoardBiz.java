package com.sev.biz;

import java.util.List;

import com.sev.dto.SEVBoardDto;

public interface SEVBoardBiz {
	
	//게시글 전체 출력
	public List<SEVBoardDto> selectAll();
	//게시글 하나 출력
	public SEVBoardDto selectOne(int bd_no);
	//글쓰기
	public boolean insert(SEVBoardDto dto);
	//글수정
	public boolean update(SEVBoardDto dto);
	//글삭제
	public boolean delete(int bd_no);
}
