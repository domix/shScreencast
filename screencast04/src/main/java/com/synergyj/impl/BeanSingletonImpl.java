package com.synergyj.impl;

import com.synergyj.BeanSingleton;

public class BeanSingletonImpl implements BeanSingleton {

	public String saluda(String nombre) {
		return "Hola " + nombre + " !!!";
	}

}
