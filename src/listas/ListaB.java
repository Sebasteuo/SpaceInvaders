
package listas;

import modelos.Invasor;
import nodo.Nodo;

/**
 * 
 * @author sebastianalba
 *
 */
public class ListaB extends ListaPadre {
/**
 * Este método se encarga de intercambiar dos nodos, en este caso el jefe con cualquier aleatorio invasor, primero se crea un Nodo auxiliar y luego se recorre el ciclo while hasta encontrar la posición del jefe, igual que con el invasor se recorre el otro while,  des pués se procede a intercambiar ambos nodos.
 */
	@Override
	public void intercambiar(int pos1, int pos2) {
		{
			Nodo jefe = raiz;
			while (jefe != null && Integer.parseInt(jefe.info.id.charAt(0) + "") != pos1) {
				jefe = jefe.sig;
			}

			Nodo actual = raiz;
			while (actual != null && Integer.parseInt(actual.info.id.charAt(0) + "") != pos2) {
				actual = actual.sig;
			}

			Invasor aux = jefe.info;
			jefe.info = actual.info;
			actual.info = aux;
		}
	}
}