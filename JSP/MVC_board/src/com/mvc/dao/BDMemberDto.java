package com.mvc.dao;

import java.util.List;

public class BDMemberDto {
	
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
		return null;
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
