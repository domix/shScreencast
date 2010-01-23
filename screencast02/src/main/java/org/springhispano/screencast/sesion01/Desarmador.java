package org.springhispano.screencast.sesion01;

import org.springframework.stereotype.Component;

@Component
public class Desarmador implements Herramienta {

	/**
	 * @see org.springhispano.screencast.sesion01.Herramienta#reparar(org.springhispano.screencast.sesion01.Computadora)
	 */
	public void reparar(Computadora computadora) {
		System.out.println("Reparando la computadora con un desarmador.");
	}

}
