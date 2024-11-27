package com.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Byecontroller {
	@GetMapping("/bye")
	public String saybye() {
		return "Bye";
	}

}
