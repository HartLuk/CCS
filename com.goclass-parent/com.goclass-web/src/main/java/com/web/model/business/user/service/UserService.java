package com.web.model.business.user.service;


import com.goclass.pojo.TbUser;
import com.goclass.result.CommonResult;

public interface UserService {
	public TbUser selectUserByAccounts(String accounts);
	
//	public CommonResult login(String accounts, String password);
	
	public TbUser self(Long userId);
}
