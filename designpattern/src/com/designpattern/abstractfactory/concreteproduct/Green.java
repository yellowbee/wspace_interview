package com.designpattern.abstractfactory.concreteproduct;

import com.designpattern.abstractfactory.abstractproduct.Color;

public class Green implements Color {

	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}

}
