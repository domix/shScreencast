package org.springhispano.screencast.sesion01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Ingeniero {
	@Autowired
	@Qualifier("desarmador")
	private Herramienta herramienta;
	
	public void reparar(Computadora computadora) {
		herramienta.reparar(computadora);
	}
}
