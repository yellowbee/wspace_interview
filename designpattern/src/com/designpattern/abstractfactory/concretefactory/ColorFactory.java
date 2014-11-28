package com.designpattern.abstractfactory.concretefactory;

import com.designpattern.abstractfactory.AbstractFactory;
import com.designpattern.abstractfactory.abstractproduct.Color;
import com.designpattern.abstractfactory.abstractproduct.Shape;
import com.designpattern.abstractfactory.concreteproduct.Blue;
import com.designpattern.abstractfactory.concreteproduct.Green;
import com.designpattern.abstractfactory.concreteproduct.Red;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if(color == null){
	         return null;
	      }		
	      if(color.equalsIgnoreCase("RED")){
	         return new Red();
	      } else if(color.equalsIgnoreCase("GREEN")){
	         return new Green();
	      } else if(color.equalsIgnoreCase("BLUE")){
	         return new Blue();
	      }
	      return null;
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}