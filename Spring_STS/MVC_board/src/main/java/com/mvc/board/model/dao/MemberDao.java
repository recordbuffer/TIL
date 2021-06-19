package com.mvc.board.model.dao;

import com.mvc.board.model.dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "mymember.";
	
	//로그인
	public MemberDto login(MemberDto dto);
}
