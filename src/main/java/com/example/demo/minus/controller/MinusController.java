package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {
	//serviceクラスのメソッドを利用するために、フィールドを定義
	private final MinusService minusService;
	//serviceクラスのメソッドを利用するために、コンストラクタを利用してフィールドにインスタンスを格納
	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}
	
	@GetMapping("minus")//ゲットメソッドと一緒 @PostMappingならPostと一緒に
	public String minusPage() {
		return "minus.html";//呼び出されるとindex.htmlを返す。
	}
		
	@PostMapping("minusCalc")
	public String minusCalc(@RequestParam("leftNum")int leftNum,
			@RequestParam("rightNum") int rightNum,Model model) {
		System.out.println(leftNum);
		System.out.println(rightNum);
		int result;
		result = minusService.minusCalculation(leftNum, rightNum);
		System.out.println(result);
		//値をHTMLに渡す
		model.addAttribute("result",result);
		
		return "minus.html";
	}
	
}
