package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;



@Controller
public class ParamController {
	// content-type : application/x-www-form-urlencoded
	// QueryString 질의 문자열 : key=value&key=value&.
	// method : 상관없음
	
	// QueryString => 커맨드 객체 (어노테이션x) : 객체
	@RequestMapping(path="comobj", method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empvo) {
		String result ="";
		result+= "Path : /comobj \n";
		result+= "\t employee_id : " + empvo.getEmployeeId();
		result+= "\t last_name : " + empvo.getLastName();
		return result;
	}
	
	
	// QueryString => @RequestParam : 기본타입, 단일값
	@RequestMapping(path="reqparm", method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String requestParm(@RequestParam Integer employeeId,String lastName,@RequestParam(name = "message", defaultValue = "No message", required = true) String msg) {
		String result ="";
		result+= "Path : /comobj \n";
		result+= "\t employee_id : " + employeeId;
		result+= "\t last_name : " + lastName;
		result+= "\t message : " + msg;
		return result;
	}
	//@pathvariable : 경로에 값으 포합하는 방식, 단일 값
	// content-type도 상관없음
	// method도 상관없음
	
	@RequestMapping("path/{id}/")//{pwd} 두세게 가능
	@ResponseBody
	public String pathVariable(@PathVariable String id) { // @PathVariable 무조건 작성 pathVariable 로 취급받을려면
		String result ="";
		result+= "Path : /path/{id} \n";
		result+= "\t id : " + id;
		return result;
	}
	// content-type : application/json
	// json 포켓 => @requestbody 배열 or 객체
	// method : post, put
	// @RequestBody 는 싱글오브젝트만 처리가능
	// json => 객체
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result ="path :/ resBody \n";
		result+= "\t employee_id : " + empVO.getEmployeeId();
		result+= "\t last_name : " + empVO.getLastName();
		return result;
	}
	// json => 배열
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList(@RequestBody List<EmpVO> list) {
		String result = "path : /resbodyList \n";
		for (EmpVO empVO : list) {
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " + empVO.getLastName();
			result += "path  \n";
		}
		return result;
	}
}
