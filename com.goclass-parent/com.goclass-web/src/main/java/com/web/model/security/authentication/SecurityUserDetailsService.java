package com.web.model.security.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.goclass.pojo.TbUser;
import com.web.model.business.user.service.UserService;

@Component
public class SecurityUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserService userService;
    
 
    /**
     * 返回 Spring Security 用户对象
     *
     * @param accounts
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String accounts) throws UsernameNotFoundException {
        /**  accounts（登录时输入的帐号）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回 */
        TbUser user = userService.selectUserByAccounts(accounts);
        if(null != user) {
            SecurityUserInfo userInfo = new SecurityUserInfo(user.getUserId(), user.getUsername(), user.getAccounts(), user.getPassword(), user.getSalt(), user.getRoleId(),
                    user.getStatus(), true, true, true, true);
            return userInfo;
        }
 
        return null;
    }
}
