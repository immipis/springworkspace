package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	private AaaMapper aaaMapper;
	
	@Autowired
	public AaaServiceImpl(AaaMapper aaaMapper) {
		this.aaaMapper = aaaMapper;
	}
	
	@Transactional // 트랜잭션을 제어 : 아래 코드를 한번에 실행 (좀더 다른 기능을 사용가능) 
	@Override
	public void aaaInsert() {
		aaaMapper.insert("101");	
		aaaMapper.insert("a101");
	}
}
