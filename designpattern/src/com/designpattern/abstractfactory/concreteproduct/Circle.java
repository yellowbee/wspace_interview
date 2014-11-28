package com.designpattern.abstractfactory.concreteproduct;

import com.designpattern.abstractfactory.abstractproduct.Shape;

public class Circle implements Shape {

	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
