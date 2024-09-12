package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
	public List<String> fizzBuzzList() {
		//リストはList<データ型> 変数名 = new ArrayList<>()で入力
		List<String> numbers = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			if (i % 15 == 0) {
				numbers.add("FizzBuzz");
			} else if (i % 3 == 0) {
				numbers.add("Fizz");
			} else if (i % 5 == 0) {
				numbers.add("Buzz");
			} else {
				numbers.add(String.valueOf(i));
				//リストには変数名.add("〇〇");で格納
			}
		}

		return numbers;
	}

}
