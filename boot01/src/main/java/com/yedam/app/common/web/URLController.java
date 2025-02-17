package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller // 빈을 등록하는 , web과 관련된 부분
public class URLController {
	
	@GetMapping("/urltest")
	@ResponseBody
	public String urlGetTest(@RequestParam String keyword) { //필수 값앞에 @RequestParam 
		//@RequestParam(defaultValue = "guest" ,  value = "name",   required = true) 기본값, 값, 필수 여부
		return "Server response : Get Method\n Select -"+keyword;
	}
	
	@PostMapping("/urltest")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server response : Post Method\n Select -"+keyword;
	}
	
	
}
