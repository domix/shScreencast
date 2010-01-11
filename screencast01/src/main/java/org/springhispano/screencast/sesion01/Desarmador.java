package org.springhispano.screencast.sesion01;

public class Desarmador implements Herramienta {

	/* (non-Javadoc)
	 * @see org.springhispano.screencast.sesion01.Herramienta#reparar(org.springhispano.screencast.sesion01.Computadora)
	 */
	public void reparar(Computadora computadora) {
		System.out.println("Reparando la computadora con un desarmador.");
	}

}
