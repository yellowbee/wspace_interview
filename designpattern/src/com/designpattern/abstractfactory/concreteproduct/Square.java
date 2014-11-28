package com.designpattern.abstractfactory.concreteproduct;

import com.designpattern.abstractfactory.abstractproduct.Shape;

public class Square implements Shape {

	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
