package com.sev.biz;

import com.jdbc.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import com.sev.dao.SEVBoardDao;
import com.sev.dao.SEVBoardDaoImpl;
import com.sev.dto.SEVBoardDto;

public class SEVBoardBizImpl implements SEVBoardBiz {
	private SEVBoardDao dao = new SEVBoardDaoImpl();
	
	@Override
	public List<SEVBoardDto> selectAll() {
		Connection con = getConnection();
		List<SEVBoardDto> res = dao.selectAll(con);
		close(con);
		
		return res;
	}

	@Override
	public SEVBoardDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SEVBoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int bd_no) {
		// TODO Auto-generated method stub
		return false;
	}

}
