package com.mvc.board.model.biz;

import com.mvc.board.model.dto.MemberDto;

public interface MemberBiz {
	//로그인
	public MemberDto login(MemberDto dto);
}
