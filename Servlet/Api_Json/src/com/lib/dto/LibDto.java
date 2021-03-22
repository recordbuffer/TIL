package com.lib.dto;

public class LibDto {
	private String gu_code;
	private int lib_seq;
	private String lib_name;
	private String addr;
	private String tel;
	private String hpg;
	
	public LibDto() {
		super();
	}

	public LibDto(String gu_code, int lib_seq, String lib_name, String addr, String tel, String hpg) {
		super();
		this.gu_code = gu_code;
		this.lib_seq = lib_seq;
		this.lib_name = lib_name;
		this.addr = addr;
		this.tel = tel;
		this.hpg = hpg;
	}

	public String getGu_code() {
		return gu_code;
	}

	public void setGu_code(String gu_code) {
		this.gu_code = gu_code;
	}

	public int getLib_seq() {
		return lib_seq;
	}

	public void setLib_seq(int lib_seq) {
		this.lib_seq = lib_seq;
	}

	public String getLib_name() {
		return lib_name;
	}

	public void setLib_name(String lib_name) {
		this.lib_name = lib_name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHpg() {
		return hpg;
	}

	public void setHpg(String hpg) {
		this.hpg = hpg;
	}

	
}
