package nodo;

import modelos.Invasor;

/**
 * 
 * @author sebastianalba
 *
 */
public class Nodo {
	public Invasor info;
	public Nodo ant, sig;

	/**
	 * Crea al nodo invasor, cada nave invasdora
	 * @param i
	 */
	public Nodo(Invasor i) {
		info = i;
	}
}