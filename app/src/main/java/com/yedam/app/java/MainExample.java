package com.yedam.app.java;

public class MainExample {
	public static void main(String[] args) {

		Chef chef = new Chef();
		Restaurant res = new Restaurant(chef);

		res.run();
	}
}
