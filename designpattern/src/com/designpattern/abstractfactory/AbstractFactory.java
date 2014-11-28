package com.designpattern.abstractfactory;

import com.designpattern.abstractfactory.abstractproduct.Color;
import com.designpattern.abstractfactory.abstractproduct.Shape;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape) ;
}
