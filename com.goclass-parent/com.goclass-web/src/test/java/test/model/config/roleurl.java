package test.model.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.GoClassApp;
import com.web.model.security.config.RoleUrlConfig;

@RunWith(SpringRunner.class)   
@SpringBootTest()// 指定启动类
public class roleurl {
	@Autowired
	RoleUrlConfig config;
	
	@Test
	public void name() {
		System.out.println(config.getApiAdminUrl());
		
	}
}
