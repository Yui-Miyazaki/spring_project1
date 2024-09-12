package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinusController {
	@GetMapping("minus")//ゲットメソッドと一緒 @PostMappingならPostと一緒に
	public String minusPage() {
		return "minus.html";//呼び出されるとindex.htmlを返す。
	}
	@PostMapping("minusCalc")
	public String minusCalc(@RequestParam("leftNum")int leftNum,
			@RequestParam("rightNum") int rightNum,Model model) {
		return "minus.html";
		
		
	}
}
