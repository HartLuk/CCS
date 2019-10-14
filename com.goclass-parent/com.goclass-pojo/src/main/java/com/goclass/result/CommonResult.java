package com.goclass.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公共返回结果类
 * 
 * @author Administrator
 *
 */
@ApiModel
public class CommonResult {
	@ApiModelProperty(notes = "状态码", example = "200", position = 0, required = true)
	private String code;
	@ApiModelProperty(notes = "描述信息", example = "success", position = 1, required = true)
	private String msg;
	@ApiModelProperty(notes = "返回数据", 
			example = "{"
			+ "\"acceessToken\":\"qefsdffs.sdfsdfsfs.sfsdfsdf\","
			+ "\"username\":\"pdh\","
			+ "\"userId\":\"2\","
			+ "\"loginTime\":\"25564232\""
			+ "}", 
			position = 0, required = true)
	private String data;
	
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public CommonResult() {
	}
	public CommonResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public CommonResult(String code, String msg, String data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	/**
	 * json格式
	 * {
	 * 	"code":"",
	 * 	"msg":"",
	 * 	"data":"{
	 * 		"acceessToken":"",
	 * 		"username":"",
	 * 		"userId":"",
	 * 		"loginTime":""
	 * 	}"
	 * }
	 */
	
}
