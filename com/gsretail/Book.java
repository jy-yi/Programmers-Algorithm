package com.gsretail;

public class Book {

	static int cnt;
	int bookNo;
	
	int getBookNo() {
		return bookNo;
	}
	
	static int getCnt() {
		return cnt;
	}
	
	void print() {
		System.out.println("총 권수 : " + cnt);
		System.out.println("책 번호 : " + bookNo);
	}
	
	static void printData() {
		System.out.println("총 권수 : " + cnt);
//		System.out.println("책 번호 : " + bookNo);
	}
	
}
