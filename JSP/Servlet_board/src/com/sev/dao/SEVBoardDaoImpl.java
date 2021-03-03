package com.sev.dao;

import java.sql.Connection;
import java.util.List;

import com.sev.dto.SEVBoardDto;

public class SEVBoardDaoImpl implements SEVBoardDao {

	@Override
	public List<SEVBoardDto> selectAll(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SEVBoardDto selectOne(Connection con, int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Connection con, SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Connection con, SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Connection con, int bd_no) {
		// TODO Auto-generated method stub
		return false;
	}

}
