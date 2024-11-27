package com.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HiController {
	@GetMapping("/hi")
	public String sayhi() {
		return "Hi";
	}
	
	@GetMapping("/Hello")
	public String sayhello() {
		return "Hello";
	}
    
}
