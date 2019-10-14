package com.web.model.rpc.server.connection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.web.GoClassApp;
import com.web.model.rpc.server.call.CallingTool;

public class ConnectionTest {
//	Connection client = new Connection();
//	public static void main(String[] args) {
//		Connection client = new Connection();
//		System.out.println(client==null);
//	}
	@Test
	public void rpcTest() {
//		Connection client = new Connection();
//		System.out.println(client.getClient().getTasksStatusForClassStrategy());
		CallingTool tool = new CallingTool();
		System.out.println(tool.getTasksStatusForClassStrategy());
	}
}
