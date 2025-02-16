package com.yedam.app.dep.service;

import java.util.Date;

import lombok.Data;

@Data
public class DepVO {
	private Integer departmentId;
	private String departmentName; 
	private Integer managerId;
	private Integer locationId;
}
