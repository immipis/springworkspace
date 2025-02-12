package com.java.app.product.impl;

import com.java.app.product.RemoteControl;

public class AudioRemocon implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Audio ON");

	}

	@Override
	public void tunrOFF() {
		System.out.println("Audio OFF");

	}

}
