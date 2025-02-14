package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService{
	private EmpMapper empMapper;
	
	@Autowired
	EmpServiceImpl(EmpMapper empMapper){
		this.empMapper = empMapper;
	}
	
	@Override
	public List<EmpVO> findAllEmp(){
		return empMapper.selectEmpList();
	}
	
	@Override
	public EmpVO findEmpInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}
	
	@Override
	public int createEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		return result == 1 ? empVO.getDepartmentId() : -1;
		
	}
	
	@Override
	public Map<String,Object> modifyEmpInfo(EmpVO empVO){
		Map<String,Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result",isSuccessed);
		map.put("target",empVO);
		
		EmpVO findVO = (EmpVO)map.get("target");
		
		return map;
	}
	
	@Override
	public Map<String,Object> removeEmpInfo(int employeeId){
		Map<String,Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(employeeId);
		
		if(result == 1) {
			map.put("employeeId",employeeId);
		}

		return map;
	}
	
}
