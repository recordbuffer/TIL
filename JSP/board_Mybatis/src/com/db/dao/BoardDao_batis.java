package com.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		SqlSession session = null;
		BoardDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne("db.board.selectOne",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	//글 추가
	public int insert(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert("db.board.insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	//글 수정
	public int update(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update("db.board.update",dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	//글 삭제
	public int delete(int bd_no) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.delete("db.board.delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	//글 여러개 삭제
	public int multiDelete(String[] bd_no) {
		SqlSession session = null;
		int cnt = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("bd_no", bd_no);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			cnt = session.delete("db.board.multiDelete",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

}
