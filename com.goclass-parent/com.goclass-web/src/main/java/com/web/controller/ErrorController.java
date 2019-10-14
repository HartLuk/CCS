package com.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goclass.result.CommonResult;

import io.swagger.annotations.ApiModel;

@RestController
@ApiModel(description = "默认错误处理")
public class ErrorController {
	
	
	@RequestMapping("/error/400/{error}")
	public CommonResult error400(@PathVariable String error) {
		return new CommonResult("400", error);
	}
	
	@RequestMapping("/error/401/{error}")
	public CommonResult error401(@PathVariable String error) {
		return new CommonResult("401", error);
	}
	@RequestMapping("/error/403/{error}")
	public CommonResult error403(@PathVariable String error) {
		return new CommonResult("403", error);
	}
	@RequestMapping("/error/404/{error}")
	public CommonResult error404(@PathVariable String error) {
		return new CommonResult("404", error);
	}
	@RequestMapping("/error/500/{error}")
	public CommonResult error500(@PathVariable String error) {
		return new CommonResult("500", error);
	}
}
