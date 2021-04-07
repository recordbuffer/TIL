package com.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.db.dto.BoardDto;

public class BoardDao_batis extends SqlMapConfig {
	
	//게시글 전체 출력 -> 목록
	public List<BoardDto> selectAll(){
		List<BoardDto> res = null;
		SqlSession session = null;
		
		//객체 정보 가져와 session 만들어줌
		try {
			session = getSqlSessionFactory().openSession(true); //auto commit : true
			
			//mapper의 selectAll 결과값 list로 담아 res로 반환
			res = session.selectList("db.board.selectAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
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
