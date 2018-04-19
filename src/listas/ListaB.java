
package listas;

import modelos.Invasor;
import nodo.Nodo;

/**
 * Es heredada de lista padre
 * @author sebastianalba
 *
 */
public class ListaB extends ListaPadre {
/**
 * Este método se encarga de intercambiar dos nodos o posiciones , en este caso el jefe con cualquier aleatorio invasor, primero se crea un Nodo auxiliar y luego se recorre el ciclo while hasta encontrar la posición del jefe, igual que con el invasor se recorre el otro while,  des pués se procede a intercambiar ambos nodos.
 * pos1 es el jefe y pos 2 es un nodo aleatorio
 */
	@Override
	public void intercambiar(int pos1, int pos2) {
		{
			/**
			 * C<rea un nodo Jefe y va a ser el primer elemento de la lista, la raiz
			 * El while es mientras el jefe no sea nulo, busca el nodo de la lista que tenga ID de J
			 * y se ejecuta hasta que encuentre el nodo con ID J, osea el jefe
			 */
			Nodo jefe = raiz;
			while (jefe != null && Integer.parseInt(jefe.info.id.charAt(0) + "") != pos1) {
				jefe = jefe.sig;
			}
			/**
			 * Este busca al nodo hasta que aparezca
			 */
			Nodo actual = raiz;
			while (actual != null && Integer.parseInt(actual.info.id.charAt(0) + "") != pos2) {
				actual = actual.sig;
			}
			/**
			 * Acá se hace el intercambio, intercambia donde está el jefe con la posicion del invasor y viceversa, pero aleatoriamente
			 */
			Invasor aux = jefe.info;
			jefe.info = actual.info;
			actual.info = aux;
		}
	}
}