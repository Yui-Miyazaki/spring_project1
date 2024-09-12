package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	//serviceクラスのメソッドを利用するために、フィールドを定義
	//serviceクラスのメソッドを利用するために、コンストラクタを利用してフィールドにインスタンスを格納
	public String calculatorPage() {
		return "calculator.html";

	}

	@PostMapping("calculation")
	public String calculation(@RequestParam("leftNum") int leftNum,
			//リクエストパラメーターの受け取り
			@RequestParam("operations") String operations,
			@RequestParam("rightNum") int rightNum,
			Model model) {
		try {//例外が発生しうる箇所（try catchで例外を潰す）
			int result = calculatorService.forCalculation(leftNum, operations,rightNum);
			//htmlに計算結果を渡す
			model.addAttribute("result",result);
		} catch (ArithmeticException e) {//エラーが起きたらcatchブロックに飛ぶ(中身の例外を)
			System.out.println("エラーが起きたよ！");
			model.addAttribute("error","ゼロ徐算はできません" );
        }
    
		return "calculator.html";
	}

}
