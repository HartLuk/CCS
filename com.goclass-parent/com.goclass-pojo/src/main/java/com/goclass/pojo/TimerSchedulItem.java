package com.goclass.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "上课时间表单项")
public class TimerSchedulItem {
	@ApiModelProperty(notes = "开始时间", example = "9:00", required = true, position = 0)
	private String start;
	@ApiModelProperty(notes = "结束时间时间", example = "9:40", required = true, position = 1)
	private String end;
	@Override
	public String toString() {
		return "TimerSchedulItem [start=" + start + ", end=" + end + "]";
	}
	
	public TimerSchedulItem() {
	}
	
	public TimerSchedulItem(String start, String end) {
		super();
		this.start = start;
		this.end = end;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
}
