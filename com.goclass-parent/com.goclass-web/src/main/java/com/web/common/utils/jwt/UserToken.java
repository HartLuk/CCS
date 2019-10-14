package com.web.common.utils.jwt;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserToken implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserToken() {}
 
    public UserToken(String username, String userId, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.authorities = authorities;
    }
 
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 权限
     * @return
     */
    private Collection<? extends GrantedAuthority> authorities;
    
    public String getUserId() {
        return userId;
    }
 
    public void setUserId(String userId) {
        this.userId = userId;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    

	@Override
	public String toString() {
		return "UserToken [userId=" + userId + ", username=" + username + ", authorities=" + authorities + "]";
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
