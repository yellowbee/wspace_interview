package com.designpattern.abstractfactory.util;

import com.designpattern.abstractfactory.AbstractFactory;
import com.designpattern.abstractfactory.concretefactory.ColorFactory;
import com.designpattern.abstractfactory.concretefactory.ShapeFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
	      if(choice.equalsIgnoreCase("SHAPE")){
	         return new ShapeFactory();
	      } else if(choice.equalsIgnoreCase("COLOR")){
	         return new ColorFactory();
	      }
	      return null;
	}
}
