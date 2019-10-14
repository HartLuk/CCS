package com.web.model.security.authentication;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUserInfo implements Serializable, UserDetails {
 
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 帐号
     */
    private String accounts;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐加密
     */
    private String salt;
    /**
     * 角色码
     */
    private int roleId;
    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;
    
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
 
    /**
     * 保存权限
     */
    private Collection<? extends GrantedAuthority> authorities;
    
    public SecurityUserInfo(Long userId, String username, String accounts, String password, String salt, int roleId, String status, 
            boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.userId = userId;
    	this.username = username;
    	this.accounts = accounts;
        this.password = password;
        this.salt = salt;
        this.roleId = roleId;
        this.status = status;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
 
    /**
     * 实现用户权限获取方法
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
    @Override
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getSalt() {
        return salt;
    }
 
    public void setSalt(String salt) {
        this.salt = salt;
    }
 
    public int getRoleId() {
        return roleId;
    }
 
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
 
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
 
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
 
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
 
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
 
    @Override
    public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	
}
