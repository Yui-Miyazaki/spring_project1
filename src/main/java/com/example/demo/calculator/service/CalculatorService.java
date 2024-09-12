package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	//呼び出し元に例外を処理させる
	public int forCalculation(int leftNum, String operation, int rightNum) throws ArithmeticException {
		int result = 0;
		if (operation.equals("+")) {
			result = leftNum + rightNum;
		} else if (operation.equals("-")) {
			result = leftNum - rightNum;
		} else if (operation.equals("×")) {
			result = leftNum * rightNum;
		} else if (operation.equals("÷")) {
			result = leftNum / rightNum;
		}

		return result;

	}

}
