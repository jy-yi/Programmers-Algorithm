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
		System.out.println("�� �Ǽ� : " + cnt);
		System.out.println("å ��ȣ : " + bookNo);
	}
	
	static void printData() {
		System.out.println("�� �Ǽ� : " + cnt);
//		System.out.println("å ��ȣ : " + bookNo);
	}
	
}
