package com.designpattern.abstractfactory.concreteproduct;

import com.designpattern.abstractfactory.abstractproduct.Shape;

public class Rectangle implements Shape {

	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");	
	}

}
