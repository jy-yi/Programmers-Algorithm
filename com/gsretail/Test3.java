package com.gsretail;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
	public static void main(String[] args) {

		Map<String, String> numberMap = new HashMap<String, String>();
		numberMap.put("0", "zero");
		numberMap.put("1", "one");
		numberMap.put("2", "two");
		numberMap.put("3", "three");
		numberMap.put("4", "four");
		numberMap.put("5", "five");
		numberMap.put("6", "six");
		numberMap.put("7", "seven");
		numberMap.put("8", "eight");
		numberMap.put("9", "nine");
		
		int num = 147;
		String numStr = String.valueOf(num);
		
		String answer = "";
		
		for (int i = 0; i < numStr.length(); i++) {
			answer += numberMap.get(numStr.substring(i,i+1));
		}
		
		System.out.println(answer);
		
		
	}
}
