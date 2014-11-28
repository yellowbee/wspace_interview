package com.designpattern.abstractfactory.util;

import com.designpattern.abstractfactory.AbstractFactory;
import com.designpattern.abstractfactory.abstractproduct.Shape;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		// get shape factory
		AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
	}
}
