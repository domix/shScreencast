package com.synergyj.impl;

import com.synergyj.BeanPrototype;
import com.synergyj.BeanSingleton;
import com.synergyj.BeanUsandoPrototypeAndSingleton;

public abstract class BeanUsandoPrototypeAndSingletonImpl implements
		BeanUsandoPrototypeAndSingleton {
	
	private BeanSingleton beanSingleton;
	private BeanPrototype beanPrototype;

	public void usandoPrototype() {
		BeanPrototype prototype1 = getBeanPrototype();
		System.out.println(prototype1.sumaDosNumeros(10, 20));
		System.out.println("beanPrototype1 = "+prototype1);
		BeanPrototype prototype2 = getBeanPrototype();
		System.out.println(prototype2.sumaDosNumeros(20, 30));
		System.out.println("beanPrototype2 = "+prototype2);
		BeanPrototype prototype3 = getBeanPrototype();
		System.out.println(prototype3.sumaDosNumeros(192, 345));
		System.out.println("beanPrototype3 = "+prototype3);
	}

	public void usandoSingleton() {
		BeanSingleton singleton1 = getBeanSingleton();
		System.out.println(singleton1.saluda("SynergyJ"));
		System.out.println("beanSingleton1 = "+singleton1);
		BeanSingleton singleton2 = getBeanSingleton();
		System.out.println(singleton2.saluda("SpringHispano"));
		System.out.println("beanSingleton1 = "+singleton2);
	}

	public BeanSingleton getBeanSingleton() {
		return beanSingleton;
	}

	public void setBeanSingleton(BeanSingleton beanSingleton) {
		this.beanSingleton = beanSingleton;
	}

	public abstract BeanPrototype getBeanPrototype();

	public void setBeanPrototype(BeanPrototype beanPrototype) {
		this.beanPrototype = beanPrototype;
	}
}
