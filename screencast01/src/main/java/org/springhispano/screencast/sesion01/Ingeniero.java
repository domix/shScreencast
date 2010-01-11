package org.springhispano.screencast.sesion01;

public class Ingeniero {
	private Herramienta herramienta;
	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}
	public void reparar(Computadora computadora) {
		herramienta.reparar(computadora);
	}
}
