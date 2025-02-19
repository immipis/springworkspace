package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 라우터 : 사용자의 요청(엔드포인트)와 그에대한 처리 url + 메소드 => 서비스 => 뷰 //모델 = req +resp 5~7 이하로
			// 만들기
public class EmpController {

	private EmpService empService;

	@Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	// get : 조회,빈페이지
	// post : 데이터 조작(등록, 수정, 삭제)

	// 전체조회 : GET
	// 1) URL + METHOD
	@GetMapping("empList") // model = request + response
	public String empList(Model model) {
		// 2) Service
		List<EmpVO> list = empService.findAllEmp();
		// 2-1) Service의 결과를 view에 전달
		model.addAttribute("emps", list);
		// 3) View
		return "emp/list";
		
		
		// prifix + return + suffix
		// classpath:/templates/emp/list.html
	}

	// 단건조회 : GET + 전달받을 데이터 => QueryString
	// 1) URL + METHOD
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		// 2) Service
		EmpVO findVO = empService.findEmpInfo(empVO);
		// 2-1) Service의 결과를 view에 전달
		model.addAttribute("emp", findVO);
		// 3) View
		return "emp/info";
	}

	// 등록 - 페이지 : GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	//classpath:/templates/emp/insert.html
	
	//등록 - 처리 : POST => form 태그를 통한 submit
	// 					=> 이미지가 있는 경우 multipart/form-data
	//					=> 이미지가 없는 경우 application/x-www-form-urlencoded
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.createEmpInfo(empVO);
		System.out.println("=============="+eid);
		String url = null;
		if(eid > -1) {
			// 정상적으로 등록 된 경우
			url = "redirect:empInfo?employeeId=" + eid;
		}else {
			url = "redirect:empList";
		}
		return url;
	}

	// 수정 - 페이지 : GET <=> 단건조회
	// 1) URL + METHOD
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
		// 2) Service
		EmpVO findVO = empService.findEmpInfo(empVO);
		// 2-1) Service의 결과를 view에 전달
		model.addAttribute("emp", findVO);
		// 3) View
		return "emp/Update";
	}

	// 수정 - 처리 : POST / AJAX => JSON(@RequestBody)
	@PostMapping("empUpdate")
	@ResponseBody // AJAX
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO) { // @RequestBody 붙이면 json 떄면 커맨드 객체 AJAX 는 // RequestBody
		return empService.modifyEmpInfo(empVO);
	}

	// 단건삭제 - 처리 : GET 전달 받을 데이터 1 건 => QueryStirng(@RequestParam)
	@GetMapping("empDelete") //empDelete?employeeId=100
	public String empDelete(Integer employeeId) {
		empService.removeEmpInfo(employeeId);
		return "redirect:empList";
	}
}
