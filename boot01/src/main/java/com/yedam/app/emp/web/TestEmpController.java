package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;


@Controller
public class TestEmpController {

	@GetMapping("/test")
	@ResponseBody
	public String selectKeyword(EmpVO empVO) {
		String result = "Result : " + empVO.getEmployeeId();
		return result;
	}
}
