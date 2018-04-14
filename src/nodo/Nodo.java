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
	 * 
	 * @param i
	 */
	public Nodo(Invasor i) {
		info = i;
	}
}