package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

	@PostMapping("/login")
	public Map<String,String> login(Authentication authentication)
	{
		Map<String,String> response=new HashMap<>();
		response.put("username", authentication.getName());
		response.put("message", "Logged in successfully");
		return response;
	}
}
