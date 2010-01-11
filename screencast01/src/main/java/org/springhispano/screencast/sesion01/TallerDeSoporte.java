package org.springhispano.screencast.sesion01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TallerDeSoporte {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");
		
		Computadora computadoraDescompuesta = new Computadora();
		
		Ingeniero ingeniero = (Ingeniero) applicationContext.getBean("ingeniero");
		ingeniero.reparar(computadoraDescompuesta);
	}
}
