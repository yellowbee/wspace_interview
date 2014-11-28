package com.designpattern.abstractfactory.concreteproduct;

import com.designpattern.abstractfactory.abstractproduct.Color;

public class Red implements Color {

	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}

}
