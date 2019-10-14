package test.model.rpc;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.web.GoClassApp;
import com.web.model.rpc.server.connection.Connection;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)   
@SpringBootTest(classes={GoClassApp.class})// 指定启动类
public class RpcTest {
//	Connection client = new Connection();
//	public static void main(String[] args) {
//		Connection client = new Connection();
//		System.out.println(client==null);
//	}
	
	
	
	
	
	@Test
	public void rpcTest() {
		Connection client = new Connection();
		System.out.println(client.getClient());
	}
}
