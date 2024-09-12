package com.example.demo.multi.service;

import org.springframework.stereotype.Service;

@Service
public class MultiService {
	public int multiple(int leftNum,int rightNum) {
		return leftNum * rightNum;
	}

}
