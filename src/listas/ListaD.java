
package listas;

import nodo.Nodo;
import modelos.Invasor;

/**
 * 
 * @author sebastianalba
 *
 */
public class ListaD extends ListaPadre {

	/**
	 * Esta función se encarga se insertar el nuevo Nodo Osea invasor en la lista, primero se pregunta si la lista esta vacia , si lo es se inserta el invasor de primero o de raiz , sino se inserta luego del primer Nodo , después se agregan los punteros de anterior y siguiente para enlazar el nuevo nodo a la lista.   
	 */
	@Override
	public Nodo insertar(Invasor x)// INSERTA DE FORMA CIRCULAR
	{
		if (vacia()) {
			raiz = new Nodo(x);
		}

		else {
			Nodo actual = raiz;
			while (actual.sig != null) {
				actual = actual.sig;
			}
			Nodo s = new Nodo(x);
			actual.sig = s;
			s.ant = actual;
			cantidad++;
			return actual;
		}
		cantidad++;
		return raiz;
	}

	/**
	 *  Este método basicamente lo que hace es enlazar el último nodo de la lista con el primero, esto quiere decir que el nodo siguiente del nodo ultimo será el primer nodo de la lista , mientras que el anterior nodo del primer nodo será el último. 
	 */
	@Override
	public void crearListaCircular() {
	}

	/**
	 *Esta función se encarga de ordenar la lista , en este caso la lista D según las resistencias de Mayor a menor , se ordena usando el algoritmo Bubble sort , primero se recorre el ciclo while para buscar el siguiente nodo del primer nodo (raiz) , cuando se encuentre se compara con el primero para ver si es mayor o menor, si el primero es menor al siguiente se procede con el intercambio , sino , no se intercambia.    
	 */
	@Override
	public void ordenarPorMayorResistencia() {
		if (cantidad > 1) {
			boolean cambio;
			do {
				Nodo actual = raiz;
				Nodo anterior = null;
				Nodo siguiente = raiz.sig;
				cambio = false;
				while (siguiente != null) {
					if (actual.info.resistencia < actual.sig.info.resistencia) {
						cambio = true;
						if (anterior != null) {
							Nodo sig = siguiente.sig;
							anterior.sig = siguiente;
							siguiente.sig = actual;
							actual.sig = sig;
						} else {
							Nodo sig = siguiente.sig;
							raiz = siguiente;
							siguiente.sig = actual;
							actual.sig = sig;
						}
						anterior = siguiente;
						siguiente = actual.sig;
					} else {
						anterior = actual;
						actual = siguiente;
						siguiente = siguiente.sig;
					}
				}
			} while (cambio);
		}
	}
}