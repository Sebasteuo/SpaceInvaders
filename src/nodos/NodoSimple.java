package nodos;

public class NodoSimple {
	private int valor;
	private NodoSimple siguiente;
	
	public void NodoSimple() {
		this.valor = 0;
		this.siguiente = null;
	}
	public  int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NodoSimple getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente(NodoSimple siguiente) {
		this.siguiente = siguiente;
	}
}
