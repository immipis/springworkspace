package com.java.app.product.impl;

import com.java.app.product.RemoteControl;

public class TvRemocon implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("Tv ON");
		
	}

	@Override
	public void tunrOFF() {
		System.out.println("Tv OFF");
	}
}
