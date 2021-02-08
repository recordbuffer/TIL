package com.multi.dto;

import java.util.Date;

public class MDBoardDto {
	/*
	 * CREATE TABLE MDBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(500) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	REGDATE DATE NOT NULL);
	 * 
	 */

	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	
	public MDBoardDto() {
		super();
	}


	public MDBoardDto(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	
	//insert
	public MDBoardDto(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	
	//update
	public MDBoardDto(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
