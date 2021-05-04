package com.mvc.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.board.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list=sqlSession.selectList(NAMESPACE+"selectList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return list;		//biz가 받아 controller로 리턴 넘겨줄거임
	}

	
	
	@Override
	public BoardDto selectOne(int bd_no) {
		BoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	
	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res=0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update",dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	
	@Override
	public int delete(int bd_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}




