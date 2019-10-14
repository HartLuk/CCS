package com.web.model.rpc.server.connection;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import com.web.model.rpc.server.source.ClassSchedulignService.Client;

public class Connection {
	private String ipAddress = "lede.dalaomai.cn";
	private String port = "5002";
	TTransport transport;
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	// 获取client
	public Client getClient() {
		try {
			// http服务 ，json协议
			this.transport = new THttpClient("http://"+ipAddress+":"+port);
			TProtocol protocol = new TJSONProtocol(transport);
			Client client = new Client(protocol);
			transport.open();
			return client;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return null;
	}
	public void closeTransport() {
		this.transport.close();
	}
}
