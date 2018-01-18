package com.oraclejava.drawing.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;

import com.oraclejava.drawing.service.ShapeService;

public class ShapeMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ShapeService service = (ShapeService)context.getBean("shapeService");

		Circle circle = service.getCircle();
		System.out.println(circle.getName());
		
		Triangle triangle = service.getTriangle();
		System.out.println(triangle.getName());
	}
}
