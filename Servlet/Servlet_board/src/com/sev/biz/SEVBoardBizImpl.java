package com.sev.biz;

import static com.jdbc.JDBCTemplate.*;
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
		Connection con = getConnection();
		SEVBoardDto dto = dao.selectOne(con, bd_no);
		close(con);
		
		return dto;
	}

	@Override
	public boolean insert(SEVBoardDto dto) {
		Connection con = getConnection();
		boolean res = dao.insert(con, dto);
		if(res) {
			commit(con);
		}
		close(con);
		
		return res;
	}

	
	
	@Override
	public boolean update(SEVBoardDto dto) {
		Connection con = getConnection();
		boolean res = dao.update(con, dto);
		if(res) {
			commit(con);
		}
		close(con);
		
		return res;
	}

	@Override
	public boolean delete(int bd_no) {
		Connection con = getConnection();
		boolean res = dao.delete(con, bd_no);
		if(res) {
			commit(con);
		}
		close(con);
		return res;
	}

}


