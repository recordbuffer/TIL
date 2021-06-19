package com.mvc.board.model.biz;

import javax.servlet.http.HttpSession;

import com.mvc.board.model.dto.MemberDto;

public interface MemberBiz {
	//로그인
	public MemberDto login(MemberDto dto);
	
	//로그아웃
	public void logout(HttpSession session);
}
