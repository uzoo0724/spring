package com.springboot.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hello.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	// 1. RequestMapping 구현 -> 스프링 4.3 버전 이후로는 사용 X
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String getHello() {
		return "Hello World";
	}
	
	// 2. 매개변수 없는 GET 메소드
	@GetMapping(value="/name")
	public String getName() {
		return "Flature";
	}
	
	// 3. PathVariable 구현 -> URL 자체에 {값}을 담아 요청, 변수의 이름 동일하게 지정
	@GetMapping(value="/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	// 3-1. PathVariable 구현 -> 변수의 이름 다르게 지정
	@GetMapping(value="/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	// 4. RequestParam 구현 -> 쿼리 형식으로 값 전달 {키} = {값}
	@GetMapping(value="/request1")
	public String getRequestParam1(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String organization) {
		return name + " " + email + " " + organization;
	}
	
	// 4-1. RequestParam 구현 -> 쿼리스트링에 어떤 값이 들어올지 모를 경우
	@GetMapping(value="/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// 4-2. RequestParam 구현 -> MemberDto 적용
		@GetMapping(value="/request3")
		public String getRequestParam3(MemberDto memberDto) {
			return memberDto.toString();
		}


}
