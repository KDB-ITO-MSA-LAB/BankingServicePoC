package com.samsungsds.kdbito.bankingservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	
	@GetMapping("/msalab")
	public String defaultFunction() {
		//테스트 주석단다.
		return "welcome";
	} 

}
