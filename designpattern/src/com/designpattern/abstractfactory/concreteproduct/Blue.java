package com.designpattern.abstractfactory.concreteproduct;

import com.designpattern.abstractfactory.abstractproduct.Color;

public class Blue implements Color {

	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}

}
