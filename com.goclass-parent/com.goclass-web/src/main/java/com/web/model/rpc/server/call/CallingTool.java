package com.web.model.rpc.server.call;

import org.apache.thrift.TException;

import com.web.model.rpc.server.connection.Connection;
import com.web.model.rpc.server.source.ClassSchedulignService.Client;
import com.web.model.rpc.server.source.ClassStrategyModifyResult;
import com.web.model.rpc.server.source.ClassStrategyRule;
import com.web.model.rpc.server.source.ResultOfClassStrategyCreateTask;
import com.web.model.rpc.server.source.ResultOfClassStrategyDelTask;
import com.web.model.rpc.server.source.ResultOfClassStrategyGetTaskResult;
import com.web.model.rpc.server.source.ResultOfClassStrategyGetTasksStatus;
import com.web.model.rpc.server.source.ResultOfClassStrategyModifyTaskResult;
import com.web.model.rpc.server.source.ResultOfClassStrategyRunTask;
import com.web.model.rpc.server.source.ResultOfGetClassStrategyRule;

public class CallingTool {
	Connection connection = new Connection();
	Client client = connection.getClient();
	//创建分班任务
	public ResultOfClassStrategyCreateTask createTaskForClassStrategy(ClassStrategyRule rule) {
		try {
			return this.client.createTaskForClassStrategy(rule);
		} catch (TException e) {
			// TODO: handle exception
			System.out.println("调用失败");
			e.printStackTrace();
		}
		return null;
	}
	//运行分班任务
	public ResultOfClassStrategyRunTask runTaskForClassStrategy(int taskID,int stage) {
		try {
			return this.client.runTaskForClassStrategy(taskID, stage);
		} catch (TException e) {
			// TODO: handle exception
			System.out.println("调用失败");
			e.printStackTrace();
		}
		return null;
	}
	//获取现有任务及其运行情况
	public ResultOfClassStrategyGetTasksStatus getTasksStatusForClassStrategy() {
		try {
			return this.client.getTasksStatusForClassStrategy();
		} catch (TException e) {
			System.out.println("调用失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	//获取任务结果
	public ResultOfClassStrategyGetTaskResult getTaskResultForClassStrategy(int taskID,int stage) {
		try {
			return this.client.getTaskResultForClassStrategy(taskID, stage);
		} catch (TException e) {
			System.out.println("调用失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	//修改结果
	public ResultOfClassStrategyModifyTaskResult modifyTaskResultForClassStrategy(ClassStrategyModifyResult classStrategyModifyResult) {
		try {
			return this.client.modifyTaskResultForClassStrategy(classStrategyModifyResult);
		} catch (TException e) {
			System.out.println("调用失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	//获取分班任务的现存规则
	public ResultOfGetClassStrategyRule getClassStrategyRule(int taskID) {
		try {
			return this.client.getClassStrategyRule(taskID);
		} catch (TException e) {
			System.out.println("调用失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	//删除分班任务
	public ResultOfClassStrategyDelTask delTaskForClassStrategy(int taskID) {
		try {
			return this.client.delTaskForClassStrategy(taskID);
		} catch (TException e) {
			System.out.println("调用失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	public Boolean ping() {
		try {
			return this.client.ping();
		} catch (Exception e) {
			System.out.println("调用失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
}
