
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
	 *      
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
	 *       
	 */
	@Override
	public void crearListaCircular() {
		Nodo ultimo = this.ultimoNodo();
		ultimo.sig = raiz.ant;
	}

	public void SeDestruyeAlJefe() {
	}

}
