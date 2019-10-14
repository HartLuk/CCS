package com.goclass.result;

public class Result {
	private String code;
	private String msg;
	private String date;
	
	
	public Result() {
	}
	
	public Result(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}



	public Result(String code, String msg, String date) {
		this.code = code;
		this.msg = msg;
		this.date = date;
	}
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
