package com.goclass.result;

import java.util.Date;

public class LoginResult extends CommonResult{
	private Long userId;
	private String username;
	private String accessToken;
	private Date loginTime;
	
	public LoginResult() {
	}
	
	public LoginResult(String code, String msg) {
		super(code, msg);
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	
}
