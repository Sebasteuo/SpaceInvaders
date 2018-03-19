package listas;
import nodos.*;

public class ListaBasic {
	private NodoSimple inicio;
	private int tamanio;
	
	public void ListaBasic() {
		inicio = null;
		tamanio = 0;
	}
	public boolean estaVacia() {
		return inicio == null;
	}
	public int getTamanio(){
		return tamanio;
	}
	public void agregarAlFinal(int valor) {
		NodoSimple nuevo = new NodoSimple();
		nuevo.setValor(valor);
		if(estaVacia()) {
			inicio = nuevo;
		}else {
			NodoSimple aux = inicio;
			while(aux.getSiguiente() != null) {
				aux = aux.getSiguiente();}
			aux.setSiguiente(nuevo);}
		tamanio ++;}
	public void removerPorPosicion(int posicion) {
		if ( posicion >= 0 && posicion < tamanio) {
			if (posicion == 0) {
				inicio = inicio.getSiguiente();
			}
			else {
				NodoSimple aux = inicio;
				for (int i= 0; i < posicion-1 ; i++) {
					aux = aux.getSiguiente();}
				NodoSimple siguiente = aux.getSiguiente();
				aux.setSiguiente(siguiente.getSiguiente());}
			tamanio --;
				}
			}
	public void vaciarLista() {
		inicio = null;
		tamanio = 0;}
	public void mostrar() {
		if(!estaVacia()) {
			NodoSimple aux = inicio;
			int i = 0;
			while(aux != null) {
				System.out.println( i + ".[ " + aux.getValor() + "]"+ " ->");
				aux = aux.getSiguiente();
				i++;
			}
		}
		}
	}
			
