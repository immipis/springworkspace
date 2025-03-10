package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;


@SpringBootTest
class Boot01ApplicationTests {
	@Autowired //필드 주입 위험함
	private EmpMapper empMapper;
	
	@Test
	void contextLoads() {
		List<EmpVO> list = empMapper.selectEmpList();
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
		assertTrue(!list.isEmpty());
	}
	
//	@Test
//	void infoTest() {
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(100);
//		
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		
//		assertEquals("King",findVO.getLastName());
		// 첫번째 매개변수 : 기대하는 값
//		// 두번쨰 매개변수 : 실제 값
//		// => 두개가 같으면 테스트 성공, 다르면 실패
//	}
//	
////	@Test
//	void insertTest() throws ParseException{
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("jo");
//		empVO.setEmail("jo1231221@daum.net");
//		empVO.setJobId("SA_REP");
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//		Date date = sdf.parse("240501");
//		
//		empVO.setHireDate(date);
//		
//		int result = empMapper.insertEmpInfo(empVO);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	void upDateTest() {
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(20);
//		
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		
//		findVO.setLastName("asd");
//		findVO.setJobId(null);
//		
//		int result = empMapper.updateEmpInfo(findVO);
//		
//		System.out.println(result);
//		assertEquals(1, result);
//	}
//	@Test
//    void delTest() {
//		int result = empMapper.deleteEmpInfo(235);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void selectKeyTest() {
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("jo");
//		empVO.setEmail("jo99991@daum.net");
//		empVO.setJobId("SA_REP");
//		// employeeId = null
//		int result = empMapper.insertEmpInfo(empVO);
//		System.out.println("===="+empVO.getEmployeeId());
//		assertEquals(1, result);
//	}
}
