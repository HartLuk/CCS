package test.model.business;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.GoClassApp;
import com.web.common.config.redis.RedisConstant;
import com.web.common.utils.SpringUtils;

@RunWith(SpringRunner.class)   
@SpringBootTest(classes={GoClassApp.class})// 指定启动类
public class TestRedis {

	RedisTemplate<Object, Object> redis;
	
	@Test
	public void test() {
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzA3NzM5NDksInVzZXJJZCI6MiwiaWF0IjoxNTcwNzcxMzU3LCJhdXRob3JpdGllcyI6eyJyb2xlSWQiOjIsInJvbGUiOiJST0xFX0FETUlOIn0sInVzZXJuYW1lIjoiYWRtaW4ifQ.4UZsKMi2K0bMLuc_iOGHUj7qDsTVIKsq4U7woWaLtEg";
//		System.out.println(redis.boundHashOps(RedisConstant.PRE_ + RedisConstant.LOGIN_USER).get(token));
	redis = (RedisTemplate<Object, Object>) SpringUtils.getBean("redisTemplate");
	redis.boundHashOps("hash").put("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzA3ODAwMjEsInVzZXJJZCI6MiwiaWF0IjoxNTcwNzc3NDI5LCJhdXRob3JpdGllcyI6eyJyb2xlSWQiOjIsInJvbGUiOiJST0xFX0FETUlOIn0sInVzZXJuYW1lIjoiYWRtaW4ifQ.-lFOsoWuI5I4s6knTQd-ML5R1qfD6UTLfz49__Y5VpY", "test");
	System.out.println(redis.boundHashOps("hash").get("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzA3ODAwMjEsInVzZXJJZCI6MiwiaWF0IjoxNTcwNzc3NDI5LCJhdXRob3JpdGllcyI6eyJyb2xlSWQiOjIsInJvbGUiOiJST0xFX0FETUlOIn0sInVzZXJuYW1lIjoiYWRtaW4ifQ.-lFOsoWuI5I4s6knTQd-ML5R1qfD6UTLfz49__Y5VpY"));
	}

}
