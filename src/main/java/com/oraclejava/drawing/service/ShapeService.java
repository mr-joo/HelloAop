package com.oraclejava.drawing.service;

import com.oraclejava.drawing.model.Circle;
import com.oraclejava.drawing.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("shapeService")
public class ShapeService {
    @Autowired
    private Triangle triangle;

    @Autowired
    private Circle circle;

    public Triangle getTriangle() {
        return triangle;
    }

    public Circle getCircle() {
        return circle;
    }
}
