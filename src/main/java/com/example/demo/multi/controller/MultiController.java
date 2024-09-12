package com.example.demo.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.multi.service.MultiService;

@Controller
public class MultiController {
	private final MultiService multiService;
	public MultiController(MultiService multiService) {
		this.multiService = multiService;
	}
	
 @GetMapping("multi")
 public String multiController(Model model) {
	 int result = multiService.multiple(5,6);
	 System.out.println(result);
	 model.addAttribute("result",result);
	 
	 return "multi.html";
	 
 }
}
