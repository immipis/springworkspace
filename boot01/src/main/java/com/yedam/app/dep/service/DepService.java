package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;

public interface DepService {
	public List<DepVO> findAllDep();
	public DepVO findDepInfo(DepVO depVO);
	public int createDepInfo(DepVO depVO);
	public Map<String,Object> modifyDepInfo(DepVO depVO);
	public Map<String,Object> removeDepInfo(int departmentId);
}
