package com.sev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sev.dto.SEVBoardDto;
import static com.jdbc.JDBCTemplate.*;

public class SEVBoardDaoImpl implements SEVBoardDao {

	@Override
	public List<SEVBoardDto> selectAll(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<SEVBoardDto> res = new ArrayList<SEVBoardDto>();
		
		try {
			pstm = con.prepareStatement(selectAllsql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				SEVBoardDto tmp = new SEVBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				res.add(tmp);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
	
		return res;
	}

	@Override
	public SEVBoardDto selectOne(Connection con, int bd_no) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		SEVBoardDto res = null;
		
		try {
			pstm = con.prepareStatement(selectOnesql);
			pstm.setInt(1, bd_no);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res = new SEVBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return res;
	}

	@Override
	public boolean insert(Connection con, SEVBoardDto dto) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(insertsql);
			pstm.setString(1, dto.getBd_name());
			pstm.setString(2, dto.getBd_title());
			pstm.setString(3, dto.getBd_content());
			
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return (res>0)?true:false;
	}

	@Override
	public boolean update(Connection con, SEVBoardDto dto) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(updatesql);
			pstm.setString(1, dto.getBd_title());
			pstm.setString(2, dto.getBd_content());
			pstm.setInt(3, dto.getBd_no());
			
			res = pstm.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return (res>0)?true:false;
	}

	@Override
	public boolean delete(Connection con, int bd_no) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(deletesql);
			pstm.setInt(1, bd_no);
			
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return (res>0)?true:false;
	}

}
