package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public Map<String,String> Home()
	{
		Map<String,String> response=new HashMap<>();
		response.put("message", "welcome to SpringBootECom ! your backend is running");
		return response;
	}
	
}
