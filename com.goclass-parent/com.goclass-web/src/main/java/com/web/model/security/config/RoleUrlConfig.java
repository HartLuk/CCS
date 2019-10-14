package com.web.model.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.web.common.config.properties.MyPropertiesSourceFactory;

@Component("roleUrlConfig")
@PropertySource(value = "classpath:properties/security.yml", factory = MyPropertiesSourceFactory.class)
public class RoleUrlConfig {
	@Value("${role-url.druid.url}")
	private String druidUrl; 
	@Value("${role-url.api.admin.url}")
	private String apiAdminUrl;
	@Value("${role-url.api.user.url}")
	private String apiUserUrl;
	@Value("${role-url.api.dba.url}")
	private String apiDbaUrl;
	@Value("${role-url.role.user}")
	private String roleUser;
	@Value("${role-url.role.admin}")
	private String roleAdmin;
	@Value("${role-url.role.dba}")
	private String roleDba;
	
	
	public String getDruidUrl() {
		return druidUrl;
	}

	public void setDruidUrl(String druidUrl) {
		this.druidUrl = druidUrl;
	}

	public String getApiAdminUrl() {
		return apiAdminUrl;
	}

	public void setApiAdminUrl(String apiAdminUrl) {
		this.apiAdminUrl = apiAdminUrl;
	}

	public String getApiUserUrl() {
		return apiUserUrl;
	}

	public void setApiUserUrl(String apiUserUrl) {
		this.apiUserUrl = apiUserUrl;
	}

	public String getApiDbaUrl() {
		return apiDbaUrl;
	}

	public void setApiDbaUrl(String apiDbaUrl) {
		this.apiDbaUrl = apiDbaUrl;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	public String getRoleAdmin() {
		return roleAdmin;
	}

	public void setRoleAdmin(String roleAdmin) {
		this.roleAdmin = roleAdmin;
	}

	public String getRoleDba() {
		return roleDba;
	}

	public void setRoleDba(String roleDba) {
		this.roleDba = roleDba;
	}
}
