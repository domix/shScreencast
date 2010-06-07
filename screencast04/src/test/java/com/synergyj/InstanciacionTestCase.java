package com.synergyj;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/AppCtx.xml" })
public class InstanciacionTestCase {

	@Autowired
	ApplicationContext appCtx;

	BeanSingleton singleton1;
	BeanSingleton singleton2;
	BeanPrototype prototype1;
	BeanPrototype prototype2;
	BeanUsandoPrototypeAndSingleton beanCombinado;

	@Before
	public void setUp() {
		singleton1 = (BeanSingleton) appCtx.getBean("beanSingleton");
		singleton2 = (BeanSingleton) appCtx.getBean("beanSingleton");
		prototype1 = (BeanPrototype) appCtx.getBean("beanPrototype");
		prototype2 = (BeanPrototype) appCtx.getBean("beanPrototype");
		beanCombinado = (BeanUsandoPrototypeAndSingleton) appCtx
				.getBean("beanUsandoPrototypeAndSingleton");
	}
	
	@After
	public void tearDown(){
		System.out.println("****************Separador de pruebas***********************");
	}

	@Test
	public void testAppCtx() {
		Assert.notNull(singleton1);
		Assert.notNull(singleton2);
		Assert.notNull(prototype1);
		Assert.notNull(prototype2);
		Assert.notNull(beanCombinado);
	}

	@Test
	public void testInstacia() {
		Assert.isTrue(singleton1 == singleton2);
		Assert.isTrue(prototype1 != prototype2);
		Assert.isTrue(beanCombinado.getBeanSingleton() == singleton1
				&& beanCombinado.getBeanSingleton() == singleton2);
		Assert.isTrue(beanCombinado.getBeanPrototype() != prototype1
				&& beanCombinado.getBeanPrototype() != prototype2);
		//¿Por qué...?
		System.out.println("Las direcciones de memoria son: ");
		System.out.println("singleton1: "+singleton1);
		System.out.println("singleton2: "+singleton2);
		System.out.println("prototype1: "+prototype1);
		System.out.println("prototype2: "+prototype2);
		System.out.println("beanSingleton dentro de beanCombinado: "+beanCombinado.getBeanSingleton());
		System.out.println("beanPrototype dentro de beanCombinado: "+beanCombinado.getBeanPrototype());
	}
	
	@Test
	public void testSingletonDentroDeSingleton(){
		beanCombinado.usandoSingleton();
	}
	
	@Test
	public void testPrototypeDentroDeSingleton(){
		beanCombinado.usandoPrototype();
	}
}
