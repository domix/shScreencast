package com.synergyj.herramientas;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springhispano.screencast.sesion01.Computadora;
import org.springhispano.screencast.sesion01.Herramienta;

@Component
@Qualifier("norton")
public class Antivirus implements Herramienta {

	public void reparar(Computadora computadora) {
		System.out.println("Reparando computadora con un Antivirus");
	}

}
