package com.designpattern.abstractfactory.concretefactory;

import com.designpattern.abstractfactory.AbstractFactory;
import com.designpattern.abstractfactory.abstractproduct.Color;
import com.designpattern.abstractfactory.abstractproduct.Shape;
import com.designpattern.abstractfactory.concreteproduct.Circle;
import com.designpattern.abstractfactory.concreteproduct.Rectangle;
import com.designpattern.abstractfactory.concreteproduct.Square;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		 if(shape == null){
	         return null;
	      }		
	      if(shape.equalsIgnoreCase("CIRCLE")){
	         return new Circle();
	      } else if(shape.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	      } else if(shape.equalsIgnoreCase("SQUARE")){
	         return new Square();
	      }
	      return null;
	}
}
