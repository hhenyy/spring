package com.example.demo.controller;

import java.util.Random;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//(@controller + @responseboy )라서 @responseboy을 따로 쓰지않아도됨.
public class HelloController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome to spring boot";
	}
	
}
