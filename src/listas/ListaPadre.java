package listas;

import nodo.*;
import modelos.Invasor;
/**
 * 
 * @author sebastianalba
 *
 */
public class ListaPadre {

	public Nodo raiz;
	public int cantidad;

	/**
	 *    
	 */
	public ListaPadre() {
		raiz = null;
		cantidad = 0;
	}

	/**
	 * 
	 * @param c
	 */
	public void setCantidad(int c) {
		cantidad = c;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	public Nodo insertar(Invasor x) {
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
	public void crearListaCircular() {
	}

	public Invasor extraer(int pos) {
		if (pos <= cantidad()) {
			Invasor informacion;
			if (pos == 1) {
				informacion = raiz.info;
				raiz = raiz.sig;
				if (raiz != null)
					raiz.ant = null;
			} else {
				Nodo reco;
				reco = raiz;
				for (int f = 1; f <= pos - 2; f++)
					reco = reco.sig;
				Nodo prox = reco.sig;
				reco.sig = prox.sig;
				Nodo siguiente = prox.sig;
				if (siguiente != null)
					siguiente.ant = reco;
				informacion = prox.info;
			}
			return informacion;
		} else
			return null;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean borrarNodo(float x, float y) {
		cantidad--;
		Nodo anterior = null;
		Nodo actual = raiz;
		while (actual != this.ultimoNodo()) {
			if (actual.info.getX() == x && actual.info.getY() == y) {

				if (anterior == null) {
					raiz = actual.sig;
					raiz.ant = null;
				} else {
					anterior.sig = actual.sig;
					Nodo temporal;
					temporal = actual.sig;
					temporal.ant = anterior;
				}
				return true;
			}
			anterior = actual;
			actual = actual.sig;
		}
		if (this.ultimoNodo().info.getX() == x && this.ultimoNodo().info.getY() == y) {
			Nodo u = this.ultimoNodo();
			if (cantidad != 0) {
				u.ant.sig = null;
			}

			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param pos1
	 * @param pos2
	 */

	public void intercambiar(int pos1, int pos2) {
		System.out.println(pos1 + "----" + pos2);

		Nodo reco1 = raiz;
		while (Integer.parseInt(reco1.info.id.charAt(0) + "") != pos1) {
			reco1 = reco1.sig;
		}

		Nodo reco2 = raiz;
		while (Integer.parseInt(reco2.info.id.charAt(0) + "") != pos1) {
			reco2 = reco2.sig;
		}

		System.out.println(reco1 + "--" + reco2);
		Invasor aux = reco1.info;
		reco1.info = reco2.info;
		reco2.info = aux;

	}

	/**
	 *     
	 */
	public void ordenarPorResistencia() {

	}

	/**
	 *  
	 */
	public void acomodarPorId() {
		Nodo actual = raiz;
		int cont = 1;
		while (actual != null) {
			actual.info.id = cont + "" + actual.info.id.charAt(1);
			cont++;
			actual = actual.sig;
		}

	}

	/**
	 * 
	 * @return
	 */
	public int cantidad() {
		Nodo reco = raiz;
		while (reco != null) {
			reco = reco.sig;
			cantidad++;
		}
		return cantidad;
	}

	/**
	 * 
	 * @return
	 */
	public boolean ordenada() {
		if (cantidad() > 1) {
			Nodo reco1 = raiz;
			Nodo reco2 = raiz.sig;
			while (reco2 != null) {
				/*
				 * if (reco2.info<reco1.info) { return false; }
				 */
				reco2 = reco2.sig;
				reco1 = reco1.sig;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	public boolean existe(Invasor x) {
		Nodo reco = raiz;
		while (reco != null) {
			if (reco.info == x)
				return true;
			reco = reco.sig;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean vacia() {
		return raiz == null;
	}

	/**
	 *     
	 */
	public void imprimir() {
		Nodo actual = raiz;
		while (actual != null) {
			System.out.print("Invasor #" + actual.info.getId() + " " + actual.info.getX() + "-" + actual.info.getY()
					+ "-" + actual.info.resistencia);
			System.out.println();
			actual = actual.sig;
		}
		System.out.println();
	}

	/**
	 * 
	 * @return
	 */
	public Nodo ultimoNodo() {
		Nodo actual = raiz;
		while (actual.sig != null) {
			actual = actual.sig;
		}
		return actual;
	}

	/**
	 *   
	 */
	public void vaciarLista() {
		raiz = null;
		cantidad = 0;
	}

	/**  
	 * 
	 */
	public void ordenarPorMayorResistencia() {
	}

	/**
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public void seDestruyeAlJefe(int pos1, int pos2) {
	}
}   
