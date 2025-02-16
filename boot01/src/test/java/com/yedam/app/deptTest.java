package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.service.DepVO;

@SpringBootTest
class deptTest {
	@Autowired //필드 주입 위험함
	private DepMapper depMapper;
	
//	@Test
//	void contextLoads() {
//		List<DepVO> list = depMapper.selectDepList();
//		for(DepVO dep : list) {
//			System.out.println(dep);
//		}
//		assertTrue(!list.isEmpty());
//	}
	
//	@Test
//	void infoTest() {
//		DepVO dmpVO = new DepVO();
//		dmpVO.setDepartmentId(10);
//		
//		DepVO findVO = depMapper.selectDepInfo(dmpVO);
//		System.out.println(findVO);
//	}
	
//	@Test
//	void insertTest() throws ParseException{
//		DepVO dmpVO = new DepVO();
//		dmpVO.setDepartmentId(999);
//		dmpVO.setDepartmentName("com");
//		dmpVO.setLocationId(1800);
//		dmpVO.setManagerId(200);
//		
//		int result = depMapper.insertDepInfo(dmpVO);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	void updateTest() throws ParseException{
//		DepVO dmpVO = new DepVO();
//		dmpVO.setDepartmentId(999);
//		
//		DepVO findVO = depMapper.selectDepInfo(dmpVO);
//		
//		findVO.setDepartmentName("122");
//		findVO.setLocationId(1800);
//		findVO.setManagerId(100);
//		
//		int result = depMapper.updateDepInfo(findVO);
//		
//		assertEquals(1, result);
//	}
	
	@Test
  void delTest() {
		int result = depMapper.deleteDepInfo(999);
		assertEquals(1, result);
	}


}
