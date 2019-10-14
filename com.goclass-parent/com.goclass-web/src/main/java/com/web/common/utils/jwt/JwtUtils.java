package com.web.common.utils.jwt;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    public static String generateToken(UserToken userToken, int expire){
        String token = Jwts.builder()
                .claim(JwtConstants.CONTEXT_USER_ID, userToken.getUserId())
                .claim(JwtConstants.CONTEXT_USERNAME, userToken.getUsername())
                .claim(JwtConstants.CONTEXT_AUTHENTICATION, userToken.getAuthorities())
                .claim(JwtConstants.RENEWAL_TIME,new Date(System.currentTimeMillis()+expire/2))	//刷新时间
                .setExpiration(new Date(System.currentTimeMillis()+expire))	//过期时间
                .signWith(SignatureAlgorithm.HS256, JwtConstants.JWT_PRIVATE_KEY)
                .compact();
        return token;
    }
 
 
    public static UserToken getInfoFromToken(String token){
    	Claims claims;
    	try {
    		claims = Jwts.parser()
                    .setSigningKey(JwtConstants.JWT_PRIVATE_KEY).parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
    	
        if (claims != null) {
        	UserToken userToken = new UserToken();
        	userToken.setUsername(claims.get(JwtConstants.CONTEXT_USERNAME).toString());
        	userToken.setUserId(claims.get(JwtConstants.CONTEXT_USER_ID).toString());
        	userToken.setAuthorities((Collection<? extends GrantedAuthority>)claims.get(JwtConstants.CONTEXT_AUTHENTICATION));
        	return userToken;
		}
        return null;
    }
    public static String getExp(String token){
    	Claims claims;
    	try {
    		claims = Jwts.parser()
                    .setSigningKey(JwtConstants.JWT_PRIVATE_KEY).parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
    	
        if (claims != null) {
        	return String.valueOf(claims.getExpiration().getTime());
		}
        return null;
    }
}
