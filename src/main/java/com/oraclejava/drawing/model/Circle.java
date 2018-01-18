package com.oraclejava.drawing.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle {
	@Value("보름달")
	private String name;

	boolean check;

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getName() throws Exception {
		/*int i = 1;
		if (i == 1) {
			throw new Exception("강제로 예외발생");
		}*/
		System.out.println("check = " + check);
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Circle [name=" + name + ", check=" + check + "]";
	}
}
