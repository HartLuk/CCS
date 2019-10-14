package test.model.business;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.GoClassApp;
import com.web.common.utils.JwtHelper;
import com.web.common.utils.SpringUtils;
import com.web.common.utils.jwt.JwtUtils;
import com.web.common.utils.jwt.UserToken;
import com.web.model.security.config.RoleUrlConfig;

import io.jsonwebtoken.Claims;

@RunWith(SpringRunner.class)   
@SpringBootTest(classes={GoClassApp.class})// 指定启动类
public class TestJwt {
	@Test
	public void test() {
		Map<String, Object> mapPy = new HashMap<>();
		/**
	     * 根据authorities、userId和userName生成token
	     */
		mapPy.put("userId", "2");
		mapPy.put("username", "123sda");
		mapPy.put("authorities", null);
		//构造token
		String accessToken = JwtHelper.generateToken(mapPy); 
		
		Claims claims = JwtHelper.verifyJwt("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzA3ODc4MjQsInVzZXJJZCI6MiwiaWF0IjoxNTcwNzg1MjMyLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn0seyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJ1c2VybmFtZSI6ImFkbWluIn0.SoEpEBZxnIpFkw94umM2y-RJs9HS7eBgAnuB1eNnPnM");
		System.out.println(claims == null);
	}
	
	@Test
	public void round() {
		long round = Math.round(-1.0);
		System.out.println(round);
		round = Math.round(-1.7);
		System.out.println(round);
	}
	@Autowired
	RoleUrlConfig config;
	@Test
	public void tt() {
		System.out.println(config.getApiAdminUrl());
		
	}
}
