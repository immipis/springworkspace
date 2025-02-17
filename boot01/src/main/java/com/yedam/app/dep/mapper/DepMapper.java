package com.yedam.app.dep.mapper;

import java.util.List;

import com.yedam.app.dep.service.DepVO;

public interface DepMapper {
	public List<DepVO> selectDepList();
	public DepVO selectDepInfo(DepVO depVO);
	public int insertDepInfo(DepVO depVO);
	public int updateDepInfo(DepVO depVO);
	public int deleteDepInfo(int depId);
}

