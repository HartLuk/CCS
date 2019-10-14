package com.web.model.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.goclass.mapper.TbRoleMapper;
import com.goclass.pojo.TbRole;
import com.goclass.pojo.TbRoleExample;
import com.goclass.pojo.TbRoleExample.Criteria;
import com.web.common.utils.Md5Util;

/**
 * 自定义认证处理类
 * 
 * @author Administrator
 *
 */
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
 
    private Logger logger = LoggerFactory.getLogger(getClass());
 
    /**
     * 注入我们自己定义的用户信息获取对象
     */
    @Autowired
    private UserDetailsService userDetailService;
    
    @Autowired
    private TbRoleMapper tbRoleMapper;
 
    /**
     * 认证用户信息
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String accounts = authentication.getName();// 这个获取表单输入中的帐号/用户名
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码
        
        /** 判断用户是否存在 */
        SecurityUserInfo userInfo = (SecurityUserInfo) userDetailService.loadUserByUsername(accounts); // 这里调用我们的自己写的获取用户的方法；
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        
        /** 验证密码是否正确*/
		if (!Md5Util.getSaltverifyMD5(password, userInfo.getPassword(), userInfo.getSalt())) {
		    throw new BadCredentialsException("密码不正确");
		}
 
        /** 
         * 判断账号是否停用/删除
         * 0正常，1停用
         **/
        if (userInfo.getStatus() == "1") {
        	throw new DisabledException("账户不可用");
        }
        
        /**
         * 根据角色，赋予不同的权限,一共三个等级
         * 用户类型		角色id		权限
         * 普通用户		1			ROLE_USER
         * 管理员		2			ROLE_ADMIN
         * 数据库管理员	3			ROLE_DBA
         * 
         * 权限包含：
         * 		1-->2
         * 		2-->3
         */
        TbRoleExample example = new TbRoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoleIdLessThanOrEqualTo(userInfo.getRoleId());
		List<TbRole> roles = tbRoleMapper.selectByExample(example);
		
		List<GrantedAuthority> authorities = new ArrayList<>();	//权限集合
		if (roles != null && roles.size() > 0) {
			for (TbRole tbRole : roles) {
				String permission = tbRole.getRole();	//权限
				authorities.add(new SimpleGrantedAuthority(permission));
			}
		}
		//权限赋予
		userInfo.setAuthorities(authorities);
		
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);// 构建返回的用户登录成功的token
    }
 
    /**
     * 执行支持判断
     *
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;// 返回 true ，表示支持执行
    }
}
