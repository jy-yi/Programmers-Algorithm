package com.gsretail;

import java.util.HashMap;

public class Test1 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "kim");
		map.put(1, "lee");
		map.put(1, "jung");
		map.put(1, "park");
		
		System.out.println(map.size());
		System.out.println(map.get(1));
		
	}
}
