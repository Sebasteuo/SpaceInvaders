
package listas;

import nodo.Nodo;
import modelos.Invasor;

/**
 * 
 * @author sebastianalba
 *
 */

public class ListaC extends ListaPadre { // LISTA CIRCULAR

	/**
	 *Esta función se encarga se insertar el nuevo Nodo, Osea invasor en la lista, primero se pregunta si la lista esta vacia , si lo es se inserta el invasor de primero o de raiz , sino se inserta luego del primer Nodo ,recorriendo el ciclo hasta llegar al último, cuando llega al ultimo se crea un nodo  después se agregan los punteros de anterior y siguiente para enlazar el nuevo nodo a la lista.      
	 */
	@Override
	public Nodo insertar(Invasor x)// INSERTA DE FORMA CIRCULAR
	{
		if (vacia()) {
			raiz = new Nodo(x);
		}

		else {
			Nodo actual = raiz;
			while (actual.sig != null) { //Ciclo que busca el ultimo, y ahí enlaza el nuevo nodo
				actual = actual.sig;
			}
			Nodo s = new Nodo(x);
			actual.sig = s; // el ultimo nodo va apuntar al nuevo nodo que estamos agregando
			s.ant = actual; // el puntero anterior del nuevo nodo va a ser igual al ultimo elemento
			cantidad++;
			return actual;
		}
		cantidad++;
		return raiz;
	}

	/**
	 * Este método basicamente lo que hace es enlazar el último nodo de la lista con el primero, esto quiere decir que el nodo siguiente del nodo ultimo será el primer nodo de la lista , mientras que el anterior nodo del primer nodo será el último.      
	 */
	@Override
	public void crearListaCircular() {
		Nodo ultimo = this.ultimoNodo();
		ultimo.sig = raiz.ant;
	}

	public void SeDestruyeAlJefe() {
	}

}
