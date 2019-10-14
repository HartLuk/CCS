package com.web.model.security;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "用户登录pojo")
public class AuthenticationBean {
	@ApiModelProperty(notes = "学号/教师号", example = "20160310235", position = 0)
    private String username;
	@ApiModelProperty(notes = "密码", example = "123456", position = 1)
    private String password;
}