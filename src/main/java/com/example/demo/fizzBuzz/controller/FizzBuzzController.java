package com.example.demo.fizzBuzz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
//リストを作成して、リストに値を格納して、html に返す
public class FizzBuzzController {

	private final FizzBuzzService fizzbuzzService;

	//コンストラクタにより、サービスクラスのインスタンス作成
	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzbuzzService = fizzBuzzService;
	}
	
	@GetMapping("fizzBuzz")
		public String fizzBuzzController(Model model) {
		//numbersリストに、fizzBuzzListメソッドから取得したfizzbuzzのリストを格納
			List<String> numbers = fizzbuzzService.fizzBuzzList();
			//fizzBuzz.htmlにnumbersrリストを渡す
			model.addAttribute("numbers",numbers);
			return "fizzBuzz.html";

		}
}
