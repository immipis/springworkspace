package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yedam.app.mybatis.service.EmpInfo;


public interface TestEmpMapper {
	// EmpDAO => EmpMapper
	// 전체조회 
	public List<EmpInfo> empList();
	
	
}
