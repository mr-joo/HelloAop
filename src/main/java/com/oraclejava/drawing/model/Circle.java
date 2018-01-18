package com.oraclejava.drawing.model;

public class Circle {
	private String name;
	
	public String getName() throws Exception {
		int i = 1;
		if (i == 1) {
			throw new Exception("강제로 예외발생");
		}
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
