package com.mvc.dao;

import static com.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mvc.dto.BDMemberDto;

public class BDMemberDao {
	
	//관리자기능 admin
	//회원 전체 정보 출력 (탈퇴회원 포함)
	public List<BDMemberDto> selectAll(){
		return null;
	}
	
	//가입 회원 정보 출력
	public List<BDMemberDto> selectEnabled(){
		return null;
	}
	
	
	//회원 등급 조정
	public int updateRole(int bm_no, String bm_role) {
		return 0;
	}
	
	
	//사용자 기능 user
	//로그인
	public BDMemberDto login(String id, String pw) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BDMemberDto res = new BDMemberDto();
		
		String sql = " SELECT * FROM BDMEMBER WHERE BM_ID=? AND BM_PW=? AND BM_ENABLED=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, "Y"); 

			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res.setBm_no(rs.getInt(1));
				res.setBm_id(rs.getString(2));
				res.setBm_pw(rs.getString(3));
				res.setBm_name(rs.getString(4));
				res.setBm_addr(rs.getString(5));
				res.setBm_phone(rs.getString(6));
				res.setBm_email(rs.getString(7));
				res.setBm_enabled(rs.getString(8));
				res.setBm_role(rs.getString(9));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return res;
	}
	
	//회원가입
	public int insertUser(BDMemberDto dto) {
		return 0;
	}
	
	//정보조회
	public BDMemberDto selectUser(int bm_no) {
		return null;
	}
	
	//수정
	public boolean updateUser(BDMemberDto dto) {
		return false;
	}
	
	//탈퇴
	public boolean deleteUser(int bm_no) {
		return false;
	}
}
